package com.example.mycurrencyapp.domain.usecase

import com.example.mycurrencyapp.domain.repository.MyCurrencyRepository

class MyCurrencyUseCase(
    private val repository: MyCurrencyRepository
) {
    suspend fun getCurrencies(): List<String> {
        return repository.getCurrencies()
    }

    suspend fun convert(
        from: String,
        to: String,
        amount: Double
    ): Double {
        val currencyRates = repository.getRates(from)

        val rate = currencyRates.rates[to]
            ?: throw Exception(EXCEPTION_MESSAGE)
        return amount * rate
    }

    private companion object {
        const val EXCEPTION_MESSAGE = "Currency not found"
    }
}