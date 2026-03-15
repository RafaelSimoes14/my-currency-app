package com.example.mycurrencyapp.data.local

import com.example.mycurrencyapp.data.local.dao.CurrencyDao
import com.example.mycurrencyapp.data.local.entity.CurrencyEntity

class LocalDataSource(
    private val currencyDao: CurrencyDao
) {
    suspend fun getCurrencies(): List<CurrencyEntity> {
        return currencyDao.getCurrencies()
    }

    suspend fun saveCurrencies(currencies: List<CurrencyEntity>) {
        currencyDao.insertCurrencies(currencies)
    }
}