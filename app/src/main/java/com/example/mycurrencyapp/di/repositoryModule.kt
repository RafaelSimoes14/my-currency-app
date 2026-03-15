package com.example.mycurrencyapp.di

import com.example.mycurrencyapp.data.repository.MyCurrencyRepositoryImpl
import com.example.mycurrencyapp.domain.repository.MyCurrencyRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<MyCurrencyRepository> {
        MyCurrencyRepositoryImpl(get(), get())
    }
}