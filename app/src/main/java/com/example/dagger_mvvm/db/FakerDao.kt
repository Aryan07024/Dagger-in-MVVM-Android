package com.example.dagger_mvvm.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.dagger_mvvm.models.ProductItems

@Dao
interface FakerDao {
    @Insert
    suspend fun addProducts(productItems: List<ProductItems>)

    @Query("SELECT * FROM ProductItems")
    suspend fun getProducts(): List<ProductItems>
}