package com.challenge.master_detail.network.data

import com.challenge.master_detail.network.BuildConfig
import com.challenge.master_detail.network.api.ApiService
import com.squareup.moshi.Moshi
import okhttp3.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject

private const val API_BASE_URL = BuildConfig.BASE_URL

class RetrofitNetwork @Inject constructor(
    okhttpCallFactory: Call.Factory,
    moshi : Moshi
) : NetworkDataSource {

    private val networkApi = Retrofit.Builder()
        .baseUrl(API_BASE_URL)
        .callFactory(okhttpCallFactory)
        .addConverterFactory(
            MoshiConverterFactory.create(
                moshi
            )
        )
        .build()

    private val colorApi = networkApi.create(ApiService::class.java)

}