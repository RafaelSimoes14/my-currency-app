package com.example.mycurrencyapp.data.network

import com.example.mycurrencyapp.data.entity.ExchangeResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MyCurrencyApi {
    @GET("latest/{base}")
    suspend fun getRates(
        @Path("base") base: String
    ): ExchangeResponse
}