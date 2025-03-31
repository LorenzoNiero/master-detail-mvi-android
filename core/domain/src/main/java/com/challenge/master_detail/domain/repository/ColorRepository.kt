package com.challenge.master_detail.domain.repository

import com.challenge.master_detail.common.domain.model.ColorModel
import kotlinx.coroutines.flow.Flow

interface ColorRepository {

    suspend fun fetchColorInfo(hexColor: String): ColorModel
    fun observeAllColor(desc : Boolean): Flow<List<ColorModel>>
    suspend fun deleteColor(color: ColorModel)
}
