package com.challenge.master_detail.domain.domain.usecase

import com.challenge.master_detail.common.domain.model.ColorModel
import com.challenge.master_detail.domain.repository.ColorRepository
import com.challenge.master_detail.domain.usecase.ObserveColorsUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class ObserveColorsUseCaseTest{
    @MockK
    private lateinit var repository: ColorRepository

    private lateinit var useCase: ObserveColorsUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        useCase = ObserveColorsUseCase(repository)
    }

    @Test
    fun `use case should call repository without error`() = runTest {
        // Given
        coEvery { repository.observeAllColor(any()) } returns flowOf(listOf())

        // When
        val result = useCase(true)

        // Then
        coVerify { repository.observeAllColor(any()) }
        assert(result is Flow<List<ColorModel>>)
    }
}