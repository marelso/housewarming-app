package com.tah.housewarming.data.housewarming

import com.tah.housewarming.data.Category
import java.lang.RuntimeException

class HousewarmingRemoteDataSource(private val service: HousewarmingService) {
    suspend fun getCategories(): List<Category> {
        val result = service.getCategories()

        if (!result.isSuccessful) throw RuntimeException("Error getting categories. ${result.message()}")

        return result.body() as List<Category>
    }

    suspend fun getCategory(id: Int): Category {
        val result = service.getCategory(id)

        if (!result.isSuccessful) throw RuntimeException("Error getting categories. ${result.message()}")

        return result.body() as Category
    }
}