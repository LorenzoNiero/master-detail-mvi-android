package com.challenge.master_detail.navigator

import androidx.navigation.NavOptionsBuilder
import com.challenge.master_detail.navigator.destination.NavigationDestination
import kotlinx.coroutines.flow.Flow

/**
 * Thanks to https://funkymuse.dev/posts/compose_hilt_mm/#building-our-navigation-module
 *
 * { launchSingleTop = true }, since we mostly need only one instance at a time when navigating to a composable screen, that’s the default for the NavOptionsBuilder since we are leveraging the following function from the navigation controller, you can tailor to your own one it doesn’t matter, consider this as it should be your guide towards your own use case.
 */

interface Navigator {
    fun navigateUp(): Boolean

    fun navigate(
        navigationDestination: NavigationDestination,
        builder: NavOptionsBuilder.() -> Unit = { launchSingleTop = true },
    ): Boolean

    fun navigate(
        navigationDestinationRoute: String,
        builder: NavOptionsBuilder.() -> Unit = { launchSingleTop = true },
    ): Boolean

    val destinations: Flow<NavigatorEvent>
}
