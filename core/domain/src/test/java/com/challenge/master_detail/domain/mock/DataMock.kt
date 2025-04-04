package com.challenge.master_detail.domain.mock

import com.challenge.master_detail.network.data.model.MediaContent
import com.challenge.master_detail.network.data.model.MediaDate
import com.challenge.master_detail.network.data.model.MediaType

object DataMock {

    val networkData = listOf<MediaContent>(
        MediaContent(
            mediaId = 1,
            mediaUrl = "https://website.xyz/namefile.pdf",
            mediaUrlBig = "",
            mediaType = MediaType.PDF,
            mediaDate =
                MediaDate(
                    dateString = "Mon, 23 Jul 2018 00:00:00 +0000",
                    year = "2018",
                ),
            mediaTitleCustom = "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
        ),
    )
}
