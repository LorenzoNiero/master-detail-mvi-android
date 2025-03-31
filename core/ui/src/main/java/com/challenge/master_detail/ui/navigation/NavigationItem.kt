package com.challenge.master_detail.ui.navigation

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavType
import androidx.navigation.navArgument

/**
 * Class that manages the route name of destination and parameters to pass
 */
sealed class NavigationItem(val baseRoute: String) {
    open val route: String = baseRoute

    object LIST : NavigationItem(ScreenEnum.LIST.name)
    object DETAIL : NavigationItem(ScreenEnum.DETAIL.name)
}

enum class ScreenEnum() {
    DETAIL,
    LIST,
}