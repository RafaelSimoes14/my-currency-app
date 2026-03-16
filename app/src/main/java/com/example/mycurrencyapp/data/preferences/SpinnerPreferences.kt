package com.example.mycurrencyapp.data.preferences

import android.content.Context
import androidx.core.content.edit

class SpinnerPreferences(context: Context) {
    private val prefs = context.getSharedPreferences(CURRENCY_PREFS, Context.MODE_PRIVATE)

    fun saveFrom(currency: String) {
        prefs.edit { putString(FROM, currency) }
    }

    fun saveTo(currency: String) {
        prefs.edit { putString(TO, currency) }
    }

    fun getFrom(): String? {
        return prefs.getString(FROM, null)
    }

    fun getTo(): String? {
        return prefs.getString(TO, null)
    }

    private companion object {
        const val CURRENCY_PREFS = "currency_prefs"
        const val FROM = "from"
        const val TO = "to"
    }
}