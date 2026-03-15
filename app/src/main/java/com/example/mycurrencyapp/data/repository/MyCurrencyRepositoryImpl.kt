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
    override suspend fun getRates(base: String): CurrencyRates {
//        val response = remoteDataSource.getRates(base)
//        return CurrencyMapper.mapToDomain(response)
        val localCurrencies = localDataSource.getCurrencies()

        if (localCurrencies.isNotEmpty()) {

            val currencies = localCurrencies.associate {
                it.code to 1.0
            }

            return CurrencyRates(
                base = base,
                rates = currencies
            )
        }

        val response = remoteDataSource.getRates(base)

        val domain = CurrencyMapper.mapToDomain(response)

        val entities = domain.rates.keys.map {
            CurrencyEntity(code = it)
        }

        localDataSource.saveCurrencies(entities)

        return domain
    }
}