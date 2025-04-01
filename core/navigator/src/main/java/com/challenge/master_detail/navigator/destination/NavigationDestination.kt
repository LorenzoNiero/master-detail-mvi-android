package com.challenge.master_detail.navigator.destination

import androidx.navigation.NamedNavArgument

interface NavigationDestination {

    fun route(): String

    val arguments: List<NamedNavArgument>
        get() = emptyList()
}

fun String.toNavigationDestination() : NavigationDestination =
    // We're splitting the route name because routes with parameters have info after the /
    when (
        NavRoutes.valueOf(
            if (this.contains("/")) {
                this.split("/")[0]
            } else {
                this.split("?")[0]
            }
        )
    ) {
        NavRoutes.LIST -> ListNavigationDestination
        NavRoutes.DETAIL -> DetailNavigationDestination
    }
