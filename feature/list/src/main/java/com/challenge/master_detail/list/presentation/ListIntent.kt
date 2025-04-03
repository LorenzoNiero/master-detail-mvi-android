package com.challenge.master_detail.list.presentation

import com.challenge.master_detail.domain.model.MediaModel

sealed class ListIntent {
    object Refresh : ListIntent()
    data class Delete(val media: MediaModel) : ListIntent()
    data class Click(val media: MediaModel) : ListIntent()
}