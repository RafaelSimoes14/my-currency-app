package com.example.mycurrencyapp.util

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner

fun Spinner.setupCurrencies(currencies: List<String>) {
    val adapter = ArrayAdapter(
        context,
        android.R.layout.simple_spinner_item,
        currencies
    )

    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    this.adapter = adapter
}

fun Spinner.restoreSelection(
    currencies: List<String>,
    savedValue: String?
) {
    savedValue?.let {

        val index = currencies.indexOf(it)

        if (index >= 0) {
            setSelection(index)
        }
    }
}

fun Spinner.onItemSelected(onSelected: (String) -> Unit) {

    onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(
            parent: AdapterView<*>,
            view: View?,
            position: Int,
            id: Long
        ) {
            val value = parent.getItemAtPosition(position) as String
            onSelected(value)
        }

        override fun onNothingSelected(parent: AdapterView<*>) {}
    }
}