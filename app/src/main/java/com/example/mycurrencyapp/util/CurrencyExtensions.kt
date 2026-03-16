package com.example.mycurrencyapp.util

import android.icu.text.NumberFormat
import java.util.Locale

private const val LANGUAGE = "pt"
private const val COUNTRY = "BR"
private const val DOT = "."
private const val COMMA = ","
private const val ZERO = 0
private const val TWO = 2

fun Double.toConversionString(
    amount: Double,
    from: String,
    to: String
): String {
    return "${amount.formatCurrency()} $from = ${this.formatCurrency()} $to"
}

fun Double.formatCurrency(): String {
    val formatter = NumberFormat.getNumberInstance(Locale(LANGUAGE, COUNTRY))
    formatter.minimumFractionDigits = TWO
    formatter.maximumFractionDigits = TWO
    return formatter.format(this)
}

fun String.toValidAmount(): Double? {

    val normalized =
        replace(COMMA, DOT).trim()

    val amount =
        normalized.toDoubleOrNull()

    return if (amount != null && amount > ZERO) amount else null
}