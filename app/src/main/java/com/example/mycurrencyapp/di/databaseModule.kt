package com.example.mycurrencyapp.di

import android.app.Application
import androidx.room.Room
import com.example.mycurrencyapp.data.local.database.AppDatabase
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(get<Application>(), AppDatabase::class.java, "currency_database")
            .build()
    }
    single { get<AppDatabase>().currencyDao() }
}