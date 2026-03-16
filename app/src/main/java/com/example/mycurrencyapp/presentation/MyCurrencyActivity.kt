package com.example.mycurrencyapp.presentation

import android.os.Bundle
import android.text.method.DigitsKeyListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.example.mycurrencyapp.data.preferences.SpinnerPreferences
import com.example.mycurrencyapp.databinding.MainActivityBinding
import com.example.mycurrencyapp.util.gone
import com.example.mycurrencyapp.util.onItemSelected
import com.example.mycurrencyapp.util.restoreSelection
import com.example.mycurrencyapp.util.setupCurrencies
import com.example.mycurrencyapp.util.toConversionString
import com.example.mycurrencyapp.util.toValidAmount
import com.example.mycurrencyapp.util.visible
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyCurrencyActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding
    private val viewModel: MyCurrencyViewModel by viewModel()
    private lateinit var prefs: SpinnerPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prefs = SpinnerPreferences(this)
        observeViewModel()
        setupListeners()
    }

    private fun observeViewModel() {
        viewModel.uiState.observe(this) { state ->
            when (state) {
                is MyCurrencyUiState.Loading -> {
                    renderLoading()
                }
                is MyCurrencyUiState.CurrenciesLoaded -> {
                    setupDropdown(state.currencies)
                }
                is MyCurrencyUiState.ConversionSuccess -> {
                    setupConversionSuccess(state)
                }
                is MyCurrencyUiState.Error -> {
                    renderError(state)
                }
            }
        }
    }

    private fun renderLoading() = with(binding) {
        progress.visible()
        linearLayout.gone()
    }

    private fun setupDropdown(currencies: List<String>) = with(binding) {
        progress.gone()
        linearLayout.visible()
        spinnerFrom.setupCurrencies(currencies)
        spinnerTo.setupCurrencies(currencies)
        spinnerFrom.restoreSelection(currencies, prefs.getFrom())
        spinnerTo.restoreSelection(currencies, prefs.getTo())
        spinnerFrom.onItemSelected { prefs.saveFrom(it) }
        spinnerTo.onItemSelected { prefs.saveTo(it) }
    }

    private fun setupConversionSuccess(state: MyCurrencyUiState.ConversionSuccess) = with(binding) {
        progress.gone()
        linearLayout.visible()
        tvResult.text = state.result.toConversionString(
            amount = state.amount,
            from = state.from,
            to = state.to
        )
    }

    private fun renderError(state: MyCurrencyUiState.Error) {
        binding.progress.gone()
        binding.linearLayout.visible()
        Toast.makeText(
            this,
            state.message,
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun validateAmount(): Double? = with(binding) {
        val amountText = etAmount.text.toString().trim()
        val amount = amountText.toValidAmount()

        if (amount == null) {
            etAmount.error = "Invalid amount"
            return null
        }
        return amount
    }

    private fun setupListeners() = with(binding) {
        etAmount.keyListener = DigitsKeyListener.getInstance("0123456789,.")
        etAmount.doAfterTextChanged {
            val amount = it.toString().toValidAmount()
            btnConvert.isEnabled = amount != null

            if (amount != null) {
                etAmount.error = null
            }
        }
        btnConvert.setOnClickListener {
            val from = spinnerFrom.selectedItem.toString()
            val to = spinnerTo.selectedItem.toString()
            val amount = validateAmount() ?: return@setOnClickListener

            viewModel.convert(
                from = from,
                to = to,
                amount = amount
            )
        }
    }
}