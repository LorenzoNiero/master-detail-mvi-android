package com.challenge.master_detail.network.data

import com.challenge.master_detail.network.api.ColorApiService
import com.challenge.master_detail.network.di.NetworkModule
import com.squareup.moshi.JsonEncodingException
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertThrows
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import kotlin.test.assertFailsWith

class ColorApiServiceTest {

    private val mockWebServer = MockWebServer()
    private lateinit var client: OkHttpClient
    private lateinit var api: ColorApiService

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
            .create(ColorApiService::class.java)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `should fetch color description success response`() = runBlocking {
        // given
        val configurationResponseModel = ApiMock.colorNetwork
        val asset = JvmUnitTestFakeAssetManager
        val mockResponse = MockResponse()
            .setResponseCode(200)
            .setBody(asset.readFileWithNewLineFromResources("get_color_description.json"))

        // when
        mockWebServer.enqueue(mockResponse)
        val response = api.getColorDescription("24B1E0")

        // then
        assertEquals(configurationResponseModel, response)
    }

    @Test
    fun `should throw a JsonEncodingException when fetching an SVG file o another format different than JSON`() : Unit = runBlocking {
        // given
        val asset = JvmUnitTestFakeAssetManager
        val mockResponse = MockResponse()
            .setResponseCode(200)
            .setBody(asset.readFileWithNewLineFromResources("get_color_format_svg.svg"))

        // when
        mockWebServer.enqueue(mockResponse)
        // assert
        assertFailsWith<JsonEncodingException> {
            api.getColorDescription("#FFAAFF")
        }
    }
}
