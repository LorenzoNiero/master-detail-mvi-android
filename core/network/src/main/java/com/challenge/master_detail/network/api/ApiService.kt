package com.challenge.master_detail.network.api

import com.challenge.master_detail.network.data.model.MediaResponse
import retrofit2.http.GET

/**
 * Implementation of endpoint
 * @see <a href="https://apivegans.veganslab.xyz/test.json">Endpoint test</a>
 *
 */
interface ApiService {
    @GET("/test.json")
    suspend fun getMediaList(): MediaResponse
}
