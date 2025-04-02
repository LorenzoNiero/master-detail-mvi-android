package com.challenge.master_detail.domain.usecase

import com.challenge.master_detail.domain.model.MediaModel
import com.challenge.master_detail.domain.repository.MediaRepository
import javax.inject.Inject

class GetMediasUseCase @Inject constructor(
    private val repository: MediaRepository
) {
    suspend operator fun invoke(): Result<List<MediaModel>> = runCatching { repository.fetchMediaList() }
}
