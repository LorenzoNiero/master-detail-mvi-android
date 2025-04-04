package com.challenge.master_detail.navigator

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NavigatorViewModel
    @Inject
    constructor(
        private val navigator: Navigator,
    ) : ViewModel(), Navigator by navigator
