package com.example.dagger_mvvm.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dagger_mvvm.models.ProductItems
import com.example.dagger_mvvm.repository.ProductRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ProductRepository): ViewModel() {
    val productLiveData: LiveData<List<ProductItems>>
        get() = repository.product

    init {
        viewModelScope.launch {
            repository.getProduct()
        }
    }
}