package com.example.dagger_mvvm.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dagger_mvvm.db.FakerDB
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideFakerDB(context: Context): FakerDB{
        return Room.databaseBuilder(context, FakerDB::class.java,"FaKerDB").build()
    }

}