package com.example.mycurrencyapp.data.remote

import com.example.mycurrencyapp.data.entity.ExchangeResponse
import com.example.mycurrencyapp.data.network.MyCurrencyApi

class RemoteDataSource(
    private val api: MyCurrencyApi
) {
    suspend fun getRates(base: String): ExchangeResponse {
        return api.getRates(base)
    }
}