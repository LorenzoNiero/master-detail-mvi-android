package com.challenge.data

import com.challenge.master_detail.data.datasource.RemoteDataSourceImpl
import com.challenge.master_detail.network.api.ApiService
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test
import kotlin.test.assertFailsWith

class RemoteDataSourceTest {
    private val apiService = mockk<ApiService>()
    private val remoteDataSourceImpl = RemoteDataSourceImpl(apiService)

    @Test
    fun `fetchMediaList should call apiService and return with success`() = runBlocking {
        // Given
        val responseMock = RemoteMock.listNetwork
        coEvery { apiService.getMediaList() } returns responseMock

        // When
        val result = remoteDataSourceImpl.fetchMediaList()

        // Then
        coVerify { apiService.getMediaList() }
        Assert.assertEquals(responseMock.content.count(), result.count())
    }


    @Test
    fun `fetchMediaList should call apiService and return with exception`() = runTest {
        // Given
        coEvery { apiService.getMediaList() } throws Exception()

        // When
        assertFailsWith<Exception> {
            remoteDataSourceImpl.fetchMediaList()
        }

        // Then
        coVerify { apiService.getMediaList() }
    }
}
