package com.challenge.master_detail.network.data

import com.challenge.master_detail.network.api.ApiService
import com.challenge.master_detail.network.di.NetworkModule
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.squareup.moshi.JsonEncodingException
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

class ApiServiceTest {

    private val mockWebServer = MockWebServer()
    private lateinit var client: OkHttpClient
    private lateinit var api: ApiService

    private val json = NetworkModule.provideJson()

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
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
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
        val response = api.getMediaList()

        // then
        assertEquals(configurationResponseModel, response)
    }

}
