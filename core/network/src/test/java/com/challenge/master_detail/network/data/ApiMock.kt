package com.challenge.master_detail.network.data

import com.challenge.master_detail.network.data.model.MediaContent
import com.challenge.master_detail.network.data.model.MediaDate
import com.challenge.master_detail.network.data.model.MediaResponse
import com.challenge.master_detail.network.data.model.MediaType

object ApiMock {
    val listNetwork =
        MediaResponse(
            status = true,
            lang = "it",
            content =
                listOf(
                    MediaContent(
                        mediaId = 16895,
                        mediaUrl = "https://apivegans.veganslab.xyz/wp-content/uploads/2018/07/6-MONCLER-NOIR-KEI-NINOMIYA-PRESS-RELEASE_ITA.pdf",
                        mediaUrlBig = "",
                        mediaType = MediaType.PDF,
                        mediaDate =
                            MediaDate(
                                dateString = "Mon, 23 Jul 2018 00:00:00 +0000",
                                year = "2018",
                            ),
                        mediaTitleCustom = "Lancio della collezione 6 Moncler Noir Kei Ninomiya",
                    ),
                ),
        )
}
