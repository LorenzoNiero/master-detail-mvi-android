package com.challenge.master_detail.data.datasource

import com.challenge.master_detail.network.api.ApiService
import com.challenge.master_detail.network.data.model.MediaContent
import javax.inject.Inject

internal class RemoteDataSourceImpl
    @Inject
    constructor(
        private val apiService: ApiService,
    ) : RemoteDataSource {
        override suspend fun fetchMediaList(): List<MediaContent> = apiService.getMediaList().content
    }
