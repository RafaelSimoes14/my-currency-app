package com.example.mycurrencyapp.domain.repository

import com.example.mycurrencyapp.domain.model.CurrencyRates

interface MyCurrencyRepository {
    suspend fun getCurrencies(): List<String>
    suspend fun getRates(base: String): CurrencyRates
}