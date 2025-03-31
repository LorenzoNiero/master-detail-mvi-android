package com.challenge.master_detail.domain.usecase

import com.challenge.master_detail.common.domain.model.ColorModel
import com.challenge.master_detail.domain.repository.ColorRepository
import javax.inject.Inject

class DeleteColorUseCase @Inject constructor(
    private val colorRepository: ColorRepository
) {
    suspend operator fun invoke(color : ColorModel): Unit = colorRepository.deleteColor(color)
}