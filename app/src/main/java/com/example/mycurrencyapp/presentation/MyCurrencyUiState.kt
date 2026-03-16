package com.example.mycurrencyapp.presentation

interface MyCurrencyUiState {
    object Loading : MyCurrencyUiState

    data class CurrenciesLoaded(
        val currencies: List<String>
    ) : MyCurrencyUiState

    data class ConversionSuccess(
        val result: Double,
        val amount: Double,
        val from: String,
        val to: String
    ) : MyCurrencyUiState

    data class Error(
        val message: String
    ) : MyCurrencyUiState
}