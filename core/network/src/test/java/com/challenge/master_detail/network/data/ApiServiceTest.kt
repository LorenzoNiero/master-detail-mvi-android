package com.challenge.master_detail.network.data

import com.challenge.master_detail.network.api.ApiService
import com.challenge.master_detail.network.di.NetworkModule
import com.squareup.moshi.JsonEncodingException
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import kotlin.test.assertFailsWith

class ApiServiceTest {

    private val mockWebServer = MockWebServer()
    private lateinit var client: OkHttpClient
    private lateinit var api: ApiService

    private val moshi = NetworkModule.parser()

    @Before
    fun setup() {
        mockWebServer.start()

        client = OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.SECONDS)
            .readTimeout(1, TimeUnit.SECONDS)
            .writeTimeout(1, TimeUnit.SECONDS)
            .build()

        api = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .client(client)
            .addConverterFactory(
                MoshiConverterFactory.create(
                    moshi
                )
            )
            .build()
            .create(ApiService::class.java)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `should fetch list success response`() = runBlocking {
        // given
        val configurationResponseModel = ApiMock.listNetwork
        val asset = JvmUnitTestFakeAssetManager
        val mockResponse = MockResponse()
            .setResponseCode(200)
            .setBody(asset.readFileWithNewLineFromResources("list.json"))

        // when
        mockWebServer.enqueue(mockResponse)
        val response = api.getList("")

        // then
        assertEquals(configurationResponseModel, response)
    }

}
