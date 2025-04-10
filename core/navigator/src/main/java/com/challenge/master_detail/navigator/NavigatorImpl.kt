package com.challenge.master_detail.navigator

import androidx.navigation.NavOptionsBuilder
import com.challenge.master_detail.navigator.destination.NavigationDestination
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class NavigatorImpl
    @Inject
    constructor() : Navigator {
    private val navigationEvents = Channel<NavigatorEvent>()
    override val destinations = navigationEvents.receiveAsFlow()

    override fun navigateUp(): Boolean =
        navigationEvents.trySend(NavigatorEvent.NavigateUp).isSuccess

    override fun navigate(
        navigationDestination: NavigationDestination,
        builder: NavOptionsBuilder.() -> Unit,
    ): Boolean = navigate(navigationDestination.route(), builder)

    override fun navigate(
        route: String,
        builder: NavOptionsBuilder.() -> Unit,
    ): Boolean =
        navigationEvents.trySend(
            NavigatorEvent.Directions(route, builder),
        ).isSuccess
}
