package com.example.mycurrencyapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mycurrencyapp.data.local.entity.CurrencyEntity

@Dao
interface CurrencyDao {
    @Query("SELECT * FROM currencies")
    suspend fun getCurrencies(): List<CurrencyEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurrencies(currencies: List<CurrencyEntity>)
}