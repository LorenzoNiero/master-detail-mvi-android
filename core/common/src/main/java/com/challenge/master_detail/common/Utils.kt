package com.challenge.master_detail.common

import java.time.LocalDateTime
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter


fun String.parseToLocalDateTime(): LocalDateTime {
    val formatter = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss Z")
    val zonedDateTime = ZonedDateTime.parse(this, formatter)
    return zonedDateTime.toLocalDateTime()
}