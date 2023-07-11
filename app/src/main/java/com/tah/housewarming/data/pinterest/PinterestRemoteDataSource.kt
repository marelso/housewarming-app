package com.tah.housewarming.data.pinterest

import androidx.core.text.HtmlCompat
import java.lang.RuntimeException

class PinterestRemoteDataSource(private val service: PinterestService) {
    suspend fun getUserPins(userId: String): List<Pin> {
        val result = service.getUserPins(userId)

        if (!result.isSuccessful) throw RuntimeException("Error getting pin info for id: $userId. ${result.message()}")


        val pins = (result.body() as UserPinsResponse).data.pins

        pins.forEach {
            it.apply {
                this.board.name = HtmlCompat.fromHtml(this.board.name, HtmlCompat.FROM_HTML_MODE_LEGACY).toString()
            }
        }

        return (result.body() as UserPinsResponse).data.pins
    }

    suspend fun getPin(pinId: String): List<PinInfo> {
        val result = service.getPins(pinId)

        if (!result.isSuccessful) throw RuntimeException("Error getting pin info for id: $pinId. ${result.message()}")
        return (result.body() as PinInfoResponse).data
    }
}