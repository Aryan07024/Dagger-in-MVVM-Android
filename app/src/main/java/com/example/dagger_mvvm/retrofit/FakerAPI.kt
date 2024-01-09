package com.example.dagger_mvvm.retrofit


import com.example.dagger_mvvm.models.ProductItems
import retrofit2.Response
import retrofit2.http.GET

interface FakerAPI {
    @GET("products")
    suspend fun getProduct(): Response<List<ProductItems>>
}