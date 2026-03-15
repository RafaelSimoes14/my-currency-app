package com.example.mycurrencyapp.data.mapper

import com.example.mycurrencyapp.data.entity.ExchangeResponse
import com.example.mycurrencyapp.domain.model.CurrencyRates

object CurrencyMapper {
    fun mapToDomain(
        response: ExchangeResponse
    ): CurrencyRates {

        return CurrencyRates(
            base = response.baseCode,
            rates = response.rates
        )
    }
}