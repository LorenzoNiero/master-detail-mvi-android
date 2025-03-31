package com.challenge.master_detail.network.data.model

import com.squareup.moshi.Json

enum class FormatResponse (){
    @Json(name = "json") JSON,
    @Json(name = "html") HTML,
    @Json(name = "svg") SVG,
}