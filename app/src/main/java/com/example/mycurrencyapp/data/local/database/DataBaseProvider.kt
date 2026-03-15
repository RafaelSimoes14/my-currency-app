package com.example.mycurrencyapp.data.local.database

import android.content.Context
import androidx.room.Room

object DataBaseProvider {
    private var INSTANCE: AppDatabase? = null

    fun getDatabase(context: Context): AppDatabase {

        return INSTANCE ?: synchronized(this) {

            val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "currency_database"
            ).build()

            INSTANCE = instance
            instance
        }
    }
}