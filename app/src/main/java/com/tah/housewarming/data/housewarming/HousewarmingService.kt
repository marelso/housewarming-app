package com.tah.housewarming.data.housewarming

import com.tah.housewarming.data.Category
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface HousewarmingService {
    @GET("v1/categories/")
    suspend fun getCategories(): Response<List<Category>>

    @GET("v1/categories/{id}")
    suspend fun getCategory(@Path("id") category: Int): Response<Category>
}