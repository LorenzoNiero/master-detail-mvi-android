package com.challenge.master_detail.navigator

import androidx.navigation.NavOptionsBuilder

sealed class NavigatorEvent {
    data object NavigateUp : NavigatorEvent()
    class Directions(val destinationRoute: String, val builder: NavOptionsBuilder.() -> Unit) : NavigatorEvent()
}
