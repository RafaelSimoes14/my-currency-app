package com.example.mycurrencyapp.di

import com.example.mycurrencyapp.domain.usecase.MyCurrencyUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { MyCurrencyUseCase(get()) }
}