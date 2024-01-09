package com.example.dagger_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.dagger_mvvm.viewmodels.MainViewModel
import com.example.dagger_mvvm.viewmodels.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory
    private val products: TextView
        get() = findViewById(R.id.products)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as FakerApplication).applicationComponent.inject(this)
        mainViewModel = ViewModelProvider(this,mainViewModelFactory)[MainViewModel::class.java]
        mainViewModel.productLiveData.observe(this) {
            it.joinToString { x -> x.title + "\n\n" }
        }
    }
}