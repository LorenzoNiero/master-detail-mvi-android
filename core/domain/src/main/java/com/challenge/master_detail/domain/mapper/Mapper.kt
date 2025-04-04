package com.challenge.master_detail.domain.mapper

import com.challenge.master_detail.common.model.MediaModel
import com.challenge.master_detail.common.model.MediaModelType
import com.challenge.master_detail.common.parseToLocalDateTime
import com.challenge.master_detail.network.data.model.MediaContent
import com.challenge.master_detail.network.data.model.MediaType


internal fun MediaContent.toDomainModel() : MediaModel = MediaModel(
    id = mediaId,
    url = mediaUrl,
    urlBig = mediaUrlBig,
    type = mediaType.toDomainModel(),
    date = mediaDate.dateString.parseToLocalDateTime(),
    title = mediaTitleCustom
)

private fun MediaType.toDomainModel(): MediaModelType {
    return when(this){
        MediaType.PDF -> MediaModelType.PDF
    }
}
