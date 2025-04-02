package com.challenge.master_detail.domain.mapper

import com.challenge.master_detail.common.parseToLocalDateTime
import com.challenge.master_detail.domain.model.MediaModel
import com.challenge.master_detail.domain.model.MediaModelType
import com.challenge.master_detail.network.data.model.MediaContent
import com.challenge.master_detail.network.data.model.MediaType
import java.time.LocalDate
import java.time.LocalDateTime


internal fun MediaContent.toDomainModel() : MediaModel = MediaModel(
    id = mediaId,
    url = mediaUrl,
    urlBig = mediaUrlBig,
    type = mediaType.toDomainModel(),
    date = mediaDate.dateString.parseToLocalDateTime(),
    title = mediaTitleCustom
)

private fun MediaType.toDomainModel(): MediaModelType {
    return MediaModelType.valueOf(this.value)
}
