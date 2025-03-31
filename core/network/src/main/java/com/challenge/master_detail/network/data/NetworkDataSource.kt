package com.challenge.master_detail.network.data

import com.challenge.master_detail.network.data.model.ColorResponse


/**
 * Interface representing network calls to the ColorApi backend
 */
interface NetworkDataSource {
    suspend fun fetchColorInfo(hex: String): ColorResponse
}