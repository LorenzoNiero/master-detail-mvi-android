package com.challenge.master_detail.domain.di

import com.challenge.master_detail.domain.repository.MediaRepository
import com.challenge.master_detail.domain.repository.MediaRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal class DomainModule {
    @Provides
    @Singleton
    fun provideRepository(repository: MediaRepositoryImpl): MediaRepository = repository
}
