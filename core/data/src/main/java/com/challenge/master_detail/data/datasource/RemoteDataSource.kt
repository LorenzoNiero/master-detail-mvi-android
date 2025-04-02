package com.challenge.master_detail.data.datasource

import com.challenge.master_detail.network.data.model.MediaContent
import com.challenge.master_detail.network.data.model.MediaResponse

interface RemoteDataSource {
    suspend fun fetchMediaList(): List<MediaContent>
}
