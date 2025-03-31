package com.challenge.data

import com.challenge.master_detail.database.model.ColorEntity

object EntityMock {
    val color = ColorEntity(
        id = "24B1E0",
        name = "Cerulean",
        hex = "#24B1E0",
    )

    val colorList = listOf(
        ColorEntity(
        id = "24B1E0",
        name = "Cerulean",
        hex = "#24B1E0",
        )
    )
}