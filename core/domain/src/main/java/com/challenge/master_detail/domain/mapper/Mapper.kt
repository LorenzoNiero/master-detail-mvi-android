package com.challenge.master_detail.domain.mapper

import com.challenge.master_detail.common.domain.model.ColorModel
import com.challenge.master_detail.database.model.ColorEntity
import com.challenge.master_detail.network.data.model.ColorResponse

internal fun ColorResponse.mapToDomainModel() : ColorModel = ColorModel(
    id = hex.clean ,
    name = this.name.value,
    hex = this.hex.value
)

internal fun ColorResponse.toEntityModel(): ColorEntity = ColorEntity(
    id = hex.clean,
    hex = hex.value,
    name = name.value
)

fun ColorEntity.asExternalModel() : ColorModel = ColorModel(
    id = id,
    name = name,
    hex = hex
)