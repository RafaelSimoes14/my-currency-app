package com.example.mycurrencyapp.domain.usecase

import com.example.mycurrencyapp.domain.repository.MyCurrencyRepository

class MyCurrencyUseCase(
    private val repository: MyCurrencyRepository
) {
    suspend fun getCurrencies(): List<String> {
        val currencyRates = repository.getRates("USD")
        return currencyRates.rates.keys.toList().sorted()
    }

    suspend fun convert(
        from: String,
        to: String,
        amount: Double
    ): Double {
        val currencyRates = repository.getRates(from)
        val rate = currencyRates.rates[to] ?: 0.0
        return amount * rate
    }
}