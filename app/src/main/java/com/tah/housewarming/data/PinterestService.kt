package com.tah.housewarming.data

import com.tah.housewarming.ui.dashboard.PinInfoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PinterestService {

    @GET("/v3/pidgets/pins/info/")
    suspend fun getPins(@Query("pin_ids") pinIds: String): Response<PinInfoResponse>

    @GET("v3/pidgets/users/{userId}/pins/")
    suspend fun getUserPins(@Path("userId") userId: String): Response<PinInfoResponse>

}