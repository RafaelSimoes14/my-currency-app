package com.example.mycurrencyapp.di

import com.example.mycurrencyapp.data.local.LocalDataSource
import com.example.mycurrencyapp.data.remote.RemoteDataSource
import org.koin.dsl.module

val dataSourceModule = module {
    single { RemoteDataSource(get()) }
    single { LocalDataSource(get()) }
}