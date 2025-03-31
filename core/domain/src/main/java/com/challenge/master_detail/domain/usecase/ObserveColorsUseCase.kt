package com.challenge.master_detail.domain.usecase

import com.challenge.master_detail.common.domain.model.ColorModel
import com.challenge.master_detail.domain.repository.ColorRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ObserveColorsUseCase @Inject constructor(
    private val colorRepository: ColorRepository
) {
    operator fun invoke(desc : Boolean): Flow<List<ColorModel>> = colorRepository.observeAllColor(desc)
}

