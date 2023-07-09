package com.tah.housewarming.ui.dashboard

data class PinInfoResponse(
    val status: String,
    val code: Int,
    val message: String,
    val endpoint_name: String,
    val data: List<PinInfo>
)

data class PinInfo(
    val link: String,
    val embed: Any?,
    val videos: Any?,
    val board: Board,
    val is_video: Boolean,
    val attribution: Any?,
    val dominant_color: String,
    val repin_count: Int,
    val aggregated_pin_data: AggregatedPinData,
    val images: Images,
    val rich_metadata: RichMetadata,
    val native_creator: Any?,
    val pinner: Pinner,
    val id: String,
    val story_pin_data: Any?,
    val description: String,
    val domain: String
)

data class Board(
    val pin_count: Int,
    val follower_count: Int,
    val description: String,
    val id: String,
    val url: String,
    val name: String,
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
    val `237x`: ImageSize,
    val `564x`: ImageSize
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
    val tracker: Any?,
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
    val authors: List<Any>,
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