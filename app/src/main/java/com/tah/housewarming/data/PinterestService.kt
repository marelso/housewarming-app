package com.tah.housewarming.data

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PinterestService {

    @GET("v3/pidgets/pins/info/?pin_ids={pinId}")
    suspend fun getPins(@Query("pinId") pinId: String)

    @GET("v3/pidgets/users/{userId}/pins/")
    suspend fun getUserPins(@Path("userId") userId: String)

}