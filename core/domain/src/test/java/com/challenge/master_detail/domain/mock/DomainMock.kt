package com.challenge.master_detail.domain.mock

import com.challenge.master_detail.common.model.MediaModel
import com.challenge.master_detail.common.model.MediaModelType
import java.time.LocalDateTime

object DomainMock {

    val listMedias : List<MediaModel> = listOf(
        MediaModel(
            id = 1,
            url = "https://website.xyz/namefile.pdf",
            urlBig = "",
            type = MediaModelType.PDF,
            date = LocalDateTime.now(),
            title = "Title",
        )
    )
}
