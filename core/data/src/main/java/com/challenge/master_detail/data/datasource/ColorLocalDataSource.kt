package com.challenge.master_detail.data.datasource

import com.challenge.master_detail.database.model.ColorEntity
import kotlinx.coroutines.flow.Flow

interface ColorLocalDataSource {

    fun onColorsUpdate(desc : Boolean): Flow<List<ColorEntity>>
    fun insertColor(color: ColorEntity)
    suspend fun deleteColor(colorId: String)

}
