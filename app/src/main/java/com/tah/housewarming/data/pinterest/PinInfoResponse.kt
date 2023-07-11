package com.tah.housewarming.data.pinterest

import com.google.gson.annotations.SerializedName

data class PinInfoResponse(
    val status: String,
    val code: Int,
    val message: String,
    val endpoint_name: String,
    val data: List<PinInfo>
)

data class PinInfo(
    val link: String,
    val board: Board,
    val is_video: Boolean,
    val dominant_color: String,
    val repin_count: Int,
    val aggregated_pin_data: AggregatedPinData,
    val images: Images,
    val rich_metadata: RichMetadata,
    val pinner: Pinner,
    val id: String,
    val description: String,
    val domain: String
)

data class Board(
    val pin_count: Int,
    val follower_count: Int,
    val description: String,
    val id: String,
    val url: String,
    var name: String,
    val image_thumbnail_url: String
)

data class AggregatedPinData(
    val aggregated_stats: AggregatedStats
)

data class AggregatedStats(
    val saves: Int,
    val done: Int
)

data class Images(
    @SerializedName("237x") val image237x: ImageSize,
    @SerializedName("564x") val image564x: ImageSize
)

data class ImageSize(
    val width: Int,
    val height: Int,
    val url: String
)

data class RichMetadata(
    val is_hard_404: Boolean,
    val amp_valid: Boolean,
    val apple_touch_icon_link: String,
    val type: String,
    val canonical_url: String?,
    val description: String,
    val favicon_link: String,
    val id: String,
    val title: String,
    val has_price_drop: Boolean,
    val url: String,
    val article: Article?,
    val locale: String,
    val link_status: Int,
    val site_name: String,
    val apple_touch_icon_images: AppleTouchIconImages?,
    val favicon_images: FaviconImages?,
    val amp_url: String
)

data class Article(
    val date_published: String?,
    val name: String,
    val type: String,
    val id: String,
    val description: String
)

data class AppleTouchIconImages(
    val orig: String,
    val `50x`: String
)

data class FaviconImages(
    val orig: String,
    val `50x`: String
)

data class Pinner(
    val image_small_url: String,
    val full_name: String,
    val pin_count: Int,
    val follower_count: Int,
    val about: String,
    val profile_url: String,
    val id: String
)