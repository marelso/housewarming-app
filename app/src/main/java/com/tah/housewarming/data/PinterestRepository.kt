package com.tah.housewarming.data

class PinterestRepository(private val remoteDatasource: PinterestRemoteDataSource) {
    suspend fun getUserPins(userId: String) {
        remoteDatasource.getUserPins(userId)
    }

    suspend fun getPin(pinId: String) {
        remoteDatasource.getPin(pinId)
    }
}