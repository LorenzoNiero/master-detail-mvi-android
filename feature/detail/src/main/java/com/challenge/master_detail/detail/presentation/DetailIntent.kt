package com.challenge.master_detail.detail.presentation

import android.content.Context

sealed class DetailIntent {
    data class ClickAndOpenExternal(val url: String, val context: Context) : DetailIntent()
}