package com.example.mycurrencyapp.domain.model

data class CurrencyRates(
    val base: String,
    val rates: Map<String, Double>
)