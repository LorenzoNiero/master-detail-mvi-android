package com.challenge.master_detail.list.presentation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun DetailScreen(viewModel: DetailViewModel = hiltViewModel()) {
    DetailContent()
}

@Composable
fun DetailContent() {
}
