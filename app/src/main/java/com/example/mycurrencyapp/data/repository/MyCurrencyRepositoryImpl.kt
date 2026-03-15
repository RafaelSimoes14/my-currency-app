package com.example.mycurrencyapp.data.repository

import com.example.mycurrencyapp.data.local.LocalDataSource
import com.example.mycurrencyapp.data.local.entity.CurrencyEntity
import com.example.mycurrencyapp.data.mapper.CurrencyMapper
import com.example.mycurrencyapp.data.remote.RemoteDataSource
import com.example.mycurrencyapp.domain.model.CurrencyRates
import com.example.mycurrencyapp.domain.repository.MyCurrencyRepository

class MyCurrencyRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : MyCurrencyRepository {

    override suspend fun getCurrencies(): List<String> {

        val local = localDataSource.getCurrencies()
        if (local.isNotEmpty()) {
            return local.map { it.code }
        }
        val response = remoteDataSource.getRates("USD")
        val currencies = response.rates.keys
        localDataSource.saveCurrencies(
            currencies.map { CurrencyEntity(it) }
        )
        return currencies.toList()
    }

    override suspend fun getRates(base: String): CurrencyRates {
        val response = remoteDataSource.getRates(base)
        return CurrencyMapper.mapToDomain(response)
    }
}