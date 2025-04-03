package com.challenge.master_detail.domain.repository

import com.challenge.master_detail.data.datasource.RemoteDataSource
import com.challenge.master_detail.domain.mapper.toDomainModel
import com.challenge.master_detail.common.model.MediaModel
import javax.inject.Inject

internal class MediaRepositoryImpl @Inject constructor(
        private val remoteDataSource: RemoteDataSource,
    ) : MediaRepository {

    override suspend fun fetchMediaList(): List<MediaModel> {
        return remoteDataSource.fetchMediaList().map { it.toDomainModel() }
    }
}


