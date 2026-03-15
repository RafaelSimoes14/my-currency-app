package com.example.mycurrencyapp.di

import com.example.mycurrencyapp.presentation.MyCurrencyViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MyCurrencyViewModel(get()) }
}