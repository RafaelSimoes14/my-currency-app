package com.example.mycurrencyapp.util

fun Double.toConversionString(
    amount: Double,
    from: String,
    to: String
): String {
    return "${amount.formatCurrency()} $from = ${this.formatCurrency()} $to"
}

fun Double.formatCurrency(): String {
    return String.format("%.2f", this)
}

fun String.toValidAmount(): Double? {

    val normalized =
        replace(",", ".").trim()

    val amount =
        normalized.toDoubleOrNull()

    return if (amount != null && amount > 0) amount else null
}