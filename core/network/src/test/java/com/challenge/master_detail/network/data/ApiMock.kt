package com.challenge.master_detail.network.data

import com.challenge.master_detail.network.data.model.ColorResponse
import com.challenge.master_detail.network.data.model.Contrast
import com.challenge.master_detail.network.data.model.Hex
import com.challenge.master_detail.network.data.model.Name

object ApiMock {
    val colorNetwork = ColorResponse(
        hex = Hex(value = "#24B1E0", clean = "24B1E0"),
        name = Name(
            value = "Cerulean",
            closestNamedHex = "#1DACD6",
            exactMatchName = false,
            distance = 356
        ),
        contrast = Contrast(value = "#000000"),
    )
}