package com.example.mycurrencyapp.data.preferences

import android.content.Context
import androidx.core.content.edit

class SpinnerPreferences(context: Context) {
    private val prefs =
        context.getSharedPreferences("currency_prefs", Context.MODE_PRIVATE)

    fun saveFrom(currency: String) {
        prefs.edit { putString("from", currency) }
    }

    fun saveTo(currency: String) {
        prefs.edit { putString("to", currency) }
    }

    fun getFrom(): String? {
        return prefs.getString("from", null)
    }

    fun getTo(): String? {
        return prefs.getString("to", null)
    }
}