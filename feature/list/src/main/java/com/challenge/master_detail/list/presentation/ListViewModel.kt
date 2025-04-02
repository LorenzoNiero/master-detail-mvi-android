package com.challenge.master_detail.list.presentation

import androidx.lifecycle.ViewModel
import com.challenge.master_detail.navigator.Navigator
import com.challenge.master_detail.navigator.destination.DetailNavigationDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel
    @Inject
    constructor(
        private val navigator: Navigator,
    ) : ViewModel(), Navigator by navigator {
        fun navigateToDetail() {
            navigator.navigate(DetailNavigationDestination)
        }
    }
