package com.challenge.master_detail.navigator.destination

import com.challenge.master_detail.navigator.R

object ListNavigationDestination : NavigationDestination {
    override fun route(): String = NavRoutes.LIST.name

    override fun titleResId(): Int = R.string.list_title

    override val isBackVisible = false
}
