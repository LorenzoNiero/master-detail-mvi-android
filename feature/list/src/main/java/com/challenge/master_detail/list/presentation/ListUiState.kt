package com.challenge.master_detail.list.presentation

import com.challenge.master_detail.domain.model.MediaModel

sealed class ListUiState {
    data object Loading : ListUiState()
    data class Error(
        val message: String?
    ) : ListUiState()
    data class Result(
        val list: List<MediaModel>
    ) : ListUiState()
    data object Empty : ListUiState()
}


