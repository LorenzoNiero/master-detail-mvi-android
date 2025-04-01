package com.challenge.master_detail.network.data.model

import com.challenge.master_detail.network.data.model.base.NetworkResponseBase
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Response (
    val name: String,
) : NetworkResponseBase()

