package com.challenge.master_detail.network.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Warning: with K2 this file have a warning but it work
 * see: https://github.com/Kotlin/kotlinx.serialization/issues/2844
 */

@Serializable
data class MediaResponse(
    val status: Boolean,
    val lang: String,
    val content: List<MediaContent>,
)

@Serializable
data class MediaContent(
    val mediaId: Long,
    val mediaUrl: String,
    val mediaUrlBig: String,
    val mediaType: MediaType,
    val mediaDate: MediaDate,
    val mediaTitleCustom: String,
)

@Serializable
data class MediaDate(
    val dateString: String,
    val year: String,
)

@Serializable
enum class MediaType(val value: String) {
    @SerialName("pdf")
    PDF("pdf"),
}
