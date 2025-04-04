package com.challenge.master_detail.domain.domain.repository

import com.challenge.master_detail.data.datasource.RemoteDataSource
import com.challenge.master_detail.domain.mock.DataMock
import com.challenge.master_detail.domain.repository.MediaRepository
import com.challenge.master_detail.domain.repository.MediaRepositoryImpl
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import kotlin.test.assertFailsWith

class MediaRepositoryTest{
    @MockK
    private lateinit var remoteDataSource: RemoteDataSource

    private lateinit var repository: MediaRepository

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true, relaxed = true)
        repository = MediaRepositoryImpl(
            remoteDataSource
        )
    }

    @Test
    fun `fetchMedias should call remoteDataSource and return with success`() = runTest {
        // Given
        val mediasNetwork = DataMock.networkData
        coEvery { remoteDataSource.fetchMediaList() } returns mediasNetwork

        // When
        repository.fetchMediaList()

        // Then
        coVerify { remoteDataSource.fetchMediaList() }
    }

    @Test
    fun `fetchMedias should call remoteDataSource and throw exception`() = runTest {
        // Given
        coEvery { remoteDataSource.fetchMediaList() } throws Exception()

        // When
        assertFailsWith<Exception> {
            repository.fetchMediaList()
        }

        // Then
        coVerify { remoteDataSource.fetchMediaList() }
    }

}
