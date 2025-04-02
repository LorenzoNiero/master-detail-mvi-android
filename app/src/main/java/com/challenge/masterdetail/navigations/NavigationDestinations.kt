package com.challenge.masterdetail.navigations

import androidx.compose.runtime.Composable
import com.challenge.master_detail.detail.direction.getDetailDestinationScreenMap
import com.challenge.master_detail.list.direction.getListDestinationScreenMap
import com.challenge.master_detail.navigator.destination.NavigationDestination

@Composable
internal fun getNavigationDestinationScreenMap(): Map<NavigationDestination, @Composable () -> Unit> =
    getListDestinationScreenMap() +
        getDetailDestinationScreenMap()
