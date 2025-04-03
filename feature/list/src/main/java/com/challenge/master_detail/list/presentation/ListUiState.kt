package com.challenge.master_detail.list.presentation

import com.challenge.master_detail.domain.model.MediaModel
import java.time.LocalDateTime

sealed class ListUiState {
    data class Error(
        val message: String?
    ) : ListUiState()
    data class Result(
        val list: List<MediaModel>
    ) : ListUiState()
    data object Empty : ListUiState()
}


