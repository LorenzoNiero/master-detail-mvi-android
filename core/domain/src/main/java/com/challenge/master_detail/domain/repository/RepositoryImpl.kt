package com.challenge.master_detail.domain.repository

import com.challenge.master_detail.data.datasource.RemoteDataSource
import javax.inject.Inject

internal class RepositoryImpl @Inject constructor(
    private val colorLocalDataSource: RemoteDataSource
) : Repository {

    override suspend fun fetchData() {
        TODO("Not yet implemented")
    }


}