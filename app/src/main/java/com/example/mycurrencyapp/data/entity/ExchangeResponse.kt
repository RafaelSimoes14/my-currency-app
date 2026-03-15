package com.example.mycurrencyapp.data.entity

import com.google.gson.annotations.SerializedName

data class ExchangeResponse(
    val result: String,
    @SerializedName("base_code")
    val baseCode: String,
    val rates: Map<String, Double>
)