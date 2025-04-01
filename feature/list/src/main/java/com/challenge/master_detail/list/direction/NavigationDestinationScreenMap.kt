package com.challenge.master_detail.list.direction

import androidx.compose.runtime.Composable
import com.challenge.master_detail.list.presentation.ListScreen
import com.challenge.master_detail.navigator.destination.ListNavigationDestination
import com.challenge.master_detail.navigator.destination.NavigationDestination

@Composable
fun getListDestinationScreenMap(): Map<NavigationDestination, @Composable () -> Unit> =
    mapOf(
        ListNavigationDestination to { ListScreen() }
    )