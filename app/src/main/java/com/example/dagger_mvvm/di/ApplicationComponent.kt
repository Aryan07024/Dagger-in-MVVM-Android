package com.example.dagger_mvvm.di

import com.example.dagger_mvvm.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {
    fun inject(main: MainActivity)
}