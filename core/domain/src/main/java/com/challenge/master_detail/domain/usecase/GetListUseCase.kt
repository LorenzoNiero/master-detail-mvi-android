package com.challenge.master_detail.domain.usecase

import com.challenge.master_detail.domain.repository.Repository
import javax.inject.Inject

class GetListUseCase @Inject constructor(
    private val repository: Repository
) {

    suspend operator fun invoke(): Result<Any> =
        runCatching { repository.fetchData() }

}