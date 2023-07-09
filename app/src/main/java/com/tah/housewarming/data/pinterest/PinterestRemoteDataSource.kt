package com.tah.housewarming.data.pinterest

import com.tah.housewarming.ui.dashboard.Pin
import com.tah.housewarming.ui.dashboard.PinInfo
import com.tah.housewarming.ui.dashboard.PinInfoResponse
import com.tah.housewarming.ui.dashboard.UserPinsResponse
import java.lang.RuntimeException

class PinterestRemoteDataSource(private val service: PinterestService) {
    suspend fun getUserPins(userId: String): List<Pin> {
        val result = service.getUserPins(userId)

        if (!result.isSuccessful) throw RuntimeException("Error getting pin info for id: $userId. ${result.message()}")
        return (result.body() as UserPinsResponse).data.pins
    }

    suspend fun getPin(pinId: String): List<PinInfo> {
        val result = service.getPins(pinId)

        if (!result.isSuccessful) throw RuntimeException("Error getting pin info for id: $pinId. ${result.message()}")
        return (result.body() as PinInfoResponse).data
    }
}