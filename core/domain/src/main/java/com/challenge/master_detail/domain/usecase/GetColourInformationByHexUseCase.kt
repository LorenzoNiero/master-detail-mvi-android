package com.challenge.master_detail.domain.usecase

import com.challenge.master_detail.common.domain.model.ColorModel
import com.challenge.master_detail.domain.repository.ColorRepository
import javax.inject.Inject

class GetColourInformationByHexUseCase @Inject constructor(
    private val repository: ColorRepository
) {

    suspend operator fun invoke( hexColor : String): Result<ColorModel> =
        runCatching { repository.fetchColorInfo(hexColor) }

}