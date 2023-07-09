package com.tah.housewarming.data

import com.tah.housewarming.ui.dashboard.PinInfoResponse

class PinterestRemoteDataSource(private val service: PinterestService) {
    suspend fun getUserPins(userId: String) {
        var result = service.getUserPins(userId)

        if (result.isSuccessful) {
            val userPins = (result.body() as PinInfoResponse).data
        }
    }

    suspend fun getPin(pinId: String) {
        service.getPins(pinId)
    }
}