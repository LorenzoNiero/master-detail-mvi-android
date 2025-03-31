package com.challenge.master_detail.network.api

import com.challenge.master_detail.network.data.model.ColorResponse
import com.challenge.master_detail.network.data.model.FormatResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Implementation of endpoint
 * @see <a href="https://www.thecolorapi.com/docs#colors-color-identification-get">Documentation</a>
 *
 */
interface ColorApiService {

    /**
     * Retrieves information about a specific color.
     *
     * @param hex Hexadecimal code of the color (e.g., "0047AB").
     * @param format Response format: "json", "html", or "svg". Default: "json".
     * @return Response containing the color information.
     */
    @GET("id")
    suspend fun getColorDescription(
        @Query("hex") hex: String,
        @Query("format") format: FormatResponse? = FormatResponse.JSON
    ) : ColorResponse

}