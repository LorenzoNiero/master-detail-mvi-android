package com.challenge.master_detail.navigator.destination

import android.net.Uri
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.challenge.master_detail.common.model.MediaModel
import com.challenge.master_detail.common.model.MediaModelType
import com.challenge.master_detail.navigator.R
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement

object DetailNavigationDestination : NavigationDestination {
    override fun route(): String = DETAILS_NAV_ROUTE

    override fun titleResId(): Int = R.string.detail_title

    override val arguments: List<NamedNavArgument>
        get() = listOf(navArgument(JSON_PARAM) { type = NavType.StringType })

    private val JSON_PARAM = "json"

    private val DETAILS_ROUTE = NavRoutes.DETAIL.name
    private val DETAILS_NAV_ROUTE = "${DETAILS_ROUTE}/{$JSON_PARAM}"

    fun createDetailsRoute(model: MediaModel) : String {
        val json = Json.encodeToString(MediaModel.serializer(), model)
        val encoded = Uri.encode(json)
        return "$DETAILS_ROUTE/${encoded}"
    }

    @Throws(IllegalStateException::class)
    fun decodeParam(savedStateHandle: SavedStateHandle) : MediaModel {
        val jsonString = savedStateHandle.get<String>(DetailNavigationDestination.JSON_PARAM)
            ?: throw IllegalStateException("Parameter step number must not be null!")
        return Json.decodeFromString<MediaModel>(Uri.decode(jsonString))
    }
}
