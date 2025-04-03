package com.challenge.master_detail.detail.presentation

import com.challenge.master_detail.common.model.MediaModel

sealed class DetailUiState {
    data class Error(
        val message: String?
    ) : DetailUiState()
    data class Detail(
        val media: MediaModel
    ) : DetailUiState()
    data object Loading : DetailUiState()
}


