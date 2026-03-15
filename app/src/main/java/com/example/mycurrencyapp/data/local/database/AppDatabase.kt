package com.example.mycurrencyapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mycurrencyapp.data.local.dao.CurrencyDao
import com.example.mycurrencyapp.data.local.entity.CurrencyEntity

@Database(
    entities = [CurrencyEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun currencyDao(): CurrencyDao
}