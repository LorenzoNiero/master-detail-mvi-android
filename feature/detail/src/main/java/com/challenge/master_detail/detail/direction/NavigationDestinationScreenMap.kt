package com.challenge.master_detail.detail.direction

import androidx.compose.runtime.Composable
import com.challenge.master_detail.detail.presentation.DetailScreen
import com.challenge.master_detail.navigator.destination.DetailNavigationDestination
import com.challenge.master_detail.navigator.destination.NavigationDestination

@Composable
fun getDetailDestinationScreenMap(): Map<NavigationDestination, @Composable () -> Unit> =
    mapOf(
        DetailNavigationDestination to { DetailScreen() },
    )
