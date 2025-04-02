package com.challenge.master_detail.navigator.destination

import com.challenge.master_detail.navigator.R

object DetailNavigationDestination : NavigationDestination {
    override fun route(): String = NavRoutes.DETAIL.name

    override fun titleResId(): Int = R.string.detail_title
}
