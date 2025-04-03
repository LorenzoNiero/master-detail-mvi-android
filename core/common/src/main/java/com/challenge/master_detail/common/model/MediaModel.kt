package com.challenge.master_detail.common.model

import com.challenge.master_detail.common.serializer.LocalDateTimeSerializer
import kotlinx.serialization.Serializable
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Serializable
data class MediaModel(
    val id: Long,
    val url: String,
    val urlBig: String,
    val type: MediaModelType,
    @Serializable(with = LocalDateTimeSerializer::class)
    val date: LocalDateTime?,
    val title: String,
){
    fun formatDate(): String {
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        return date?.format(formatter)?.toString() ?: ""
    }
}

