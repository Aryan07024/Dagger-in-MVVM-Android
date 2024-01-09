package com.example.dagger_mvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dagger_mvvm.db.FakerDB
import com.example.dagger_mvvm.models.ProductItems
import com.example.dagger_mvvm.retrofit.FakerAPI
import javax.inject.Inject

class ProductRepository @Inject constructor(private val fakerAPI: FakerAPI, private val fakerDB: FakerDB) {
    private val _products = MutableLiveData<List<ProductItems>>()
    val product: LiveData<List<ProductItems>>
        get() = _products
    suspend fun getProduct(){
        val result = fakerAPI.getProduct()
        if (result.isSuccessful && result.body() != null){
            fakerDB.getFakerDAO().addProducts(result.body()!!)
            _products.postValue(result.body())
        }
    }
}