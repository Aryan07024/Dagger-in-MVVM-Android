package com.example.dagger_mvvm.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dagger_mvvm.models.ProductItems

@Database(entities = [ProductItems::class], version = 1)
abstract class FakerDB: RoomDatabase() {
    abstract fun getFakerDAO(): FakerDao
}