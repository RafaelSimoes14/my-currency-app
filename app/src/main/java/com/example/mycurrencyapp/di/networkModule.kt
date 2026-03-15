package com.example.mycurrencyapp.di

import com.example.mycurrencyapp.data.network.MyCurrencyApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }
    single {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }
    single {
        Retrofit.Builder()
            .baseUrl("https://open.er-api.com/v6/")
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single<MyCurrencyApi> {
        get<Retrofit>().create(MyCurrencyApi::class.java)
    }
}