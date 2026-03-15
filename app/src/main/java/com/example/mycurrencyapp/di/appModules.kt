package com.example.mycurrencyapp.di

import org.koin.core.module.Module

val appModules: List<Module> = listOf(
    viewModelModule,
    networkModule,
    dataSourceModule,
    repositoryModule,
    useCaseModule,
    databaseModule
)