package com.example.mycurrencyapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycurrencyapp.domain.usecase.MyCurrencyUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MyCurrencyViewModel(
    private val currencyUseCase: MyCurrencyUseCase
) : ViewModel() {
    private val _uiState =
        MutableLiveData<MyCurrencyUiState>()
    val uiState: LiveData<MyCurrencyUiState> = _uiState

    init {
        loadCurrencies()
    }

    private fun loadCurrencies() {
        _uiState.value = MyCurrencyUiState.Loading
        viewModelScope.launch {
            try {
                val currencies = currencyUseCase.getCurrencies()
                _uiState.value =
                    MyCurrencyUiState.CurrenciesLoaded(currencies)

            } catch (e: Exception) {
                _uiState.value =
                    MyCurrencyUiState.Error(
                        "Erro ao carregar moedas"
                    )
            }
        }
    }

    fun convert(
        from: String,
        to: String,
        amount: Double
    ) {
        _uiState.value = MyCurrencyUiState.Loading

        viewModelScope.launch {
            delay(1000)
            try {
                val result = currencyUseCase.convert(from, to, amount)
                _uiState.value = MyCurrencyUiState.ConversionSuccess(
                    amount = amount,
                    from = from,
                    to = to,
                    result = result
                )
            } catch (e: Exception) {
                _uiState.value =
                    MyCurrencyUiState.Error(
                        "Erro na conversão"
                    )
            }
        }
    }
}