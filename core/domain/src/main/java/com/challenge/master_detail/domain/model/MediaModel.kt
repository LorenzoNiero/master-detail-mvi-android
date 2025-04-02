package com.challenge.master_detail.domain.model

import java.time.LocalDate
import java.time.LocalDateTime

data class MediaModel(
    val id: Long,
    val url: String,
    val urlBig: String,
    val type: MediaModelType,
    val date: LocalDateTime?,
    val title: String,
)

