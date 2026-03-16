package com.example.mycurrencyapp.util

import android.icu.text.NumberFormat
import java.util.Locale

fun Double.toConversionString(
    amount: Double,
    from: String,
    to: String
): String {
    return "${amount.formatCurrency()} $from = ${this.formatCurrency()} $to"
}

fun Double.formatCurrency(): String {
    val formatter = NumberFormat.getNumberInstance(Locale("pt", "BR"))
    formatter.minimumFractionDigits = 2
    formatter.maximumFractionDigits = 2
    return formatter.format(this)
}

fun String.toValidAmount(): Double? {

    val normalized =
        replace(",", ".").trim()

    val amount =
        normalized.toDoubleOrNull()

    return if (amount != null && amount > 0) amount else null
}