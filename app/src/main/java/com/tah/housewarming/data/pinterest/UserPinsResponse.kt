package com.tah.housewarming.data.pinterest

data class UserPinsResponse(
    val status: String,
    val code: Int,
    val message: String,
    val endpoint_name: String,
    val data: UserPinsData
)

data class User(
    val pin_count: Int,
    val about: String,
    val follower_count: Int,
    val image_small_url: String,
    val id: String,
    val profile_url: String,
    val full_name: String
)

data class Pin(
    val dominant_color: String,
    val link: String,
    val images: PinImages,
    val domain: String,
    val repin_count: Int,
    val pinner: User,
    val id: String,
    val description: String,
    val is_video: Boolean,
    val aggregated_pin_data: AggregatedPinData,
    val board: Board
)

data class PinImages(
    val `237x`: Image,
    val `564x`: Image
)

data class Image(
    val width: Int,
    val height: Int,
    val url: String
)

data class UserPinsData(
    val user: User,
    val pins: List<Pin>
)