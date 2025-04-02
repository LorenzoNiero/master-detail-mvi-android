package com.challenge.master_detail.domain.repository

import com.challenge.master_detail.domain.model.MediaModel

interface MediaRepository {
    suspend fun fetchMediaList() : List<MediaModel>
}
