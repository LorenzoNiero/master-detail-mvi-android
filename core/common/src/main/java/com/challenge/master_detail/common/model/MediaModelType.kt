package com.challenge.master_detail.common.model

import kotlinx.serialization.Serializable

@Serializable
enum class MediaModelType constructor(val value: String) {
    PDF("pdf"),
}