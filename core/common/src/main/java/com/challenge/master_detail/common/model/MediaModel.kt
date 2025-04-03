package com.challenge.master_detail.common.model

import com.challenge.master_detail.common.serializer.LocalDateTimeSerializer
import kotlinx.serialization.Serializable
import java.time.LocalDateTime

@Serializable
data class MediaModel(
    val id: Long,
    val url: String,
    val urlBig: String,
    val type: MediaModelType,
    @Serializable(with = LocalDateTimeSerializer::class)
    val date: LocalDateTime?,
    val title: String,
)

