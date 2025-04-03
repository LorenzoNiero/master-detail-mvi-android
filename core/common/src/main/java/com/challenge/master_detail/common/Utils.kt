package com.challenge.master_detail.common

import android.util.Log
import java.time.LocalDateTime
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale


fun String.parseToLocalDateTime(): LocalDateTime? {
    return runCatching {
        val formatter = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH)
        val zonedDateTime = ZonedDateTime.parse(this, formatter)
        zonedDateTime.toLocalDateTime()
    }.getOrElse {
        Log.e("Error parsing date", it.toString())
        null
    }
}


