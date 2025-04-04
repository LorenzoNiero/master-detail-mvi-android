package com.challenge.master_detail.domain.domain.usecase

import com.challenge.master_detail.domain.mock.DomainMock
import com.challenge.master_detail.domain.repository.MediaRepository
import com.challenge.master_detail.domain.usecase.GetMediasUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class GetMediasUseCaseTest {
    @MockK
    private lateinit var repository: MediaRepository

    private lateinit var useCase: GetMediasUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        useCase = GetMediasUseCase(repository)
    }

    @Test
    fun `use case should call repository without error`() = runTest {
        // Given
        coEvery { repository.fetchMediaList() } returns DomainMock.listMedias

        // When
        val response = useCase()

        // Then
        coVerify { repository.fetchMediaList() }
        assert(response.isSuccess)
    }

    @Test
    fun `use case should call repository with error`() = runTest {
        // Given
        coEvery { repository.fetchMediaList() } throws Exception()

        // When
        val response = useCase()

        // Then
        coVerify { repository.fetchMediaList() }
        assert(response.isFailure)
    }

}