package com.challenge.master_detail.detail

import android.content.Context
import android.content.Intent
import androidx.core.net.toUri

fun openPdfInExternalApp(context: Context, url: String) {
    val intent = Intent(Intent.ACTION_VIEW, url.toUri())
    context.startActivity(intent)
}