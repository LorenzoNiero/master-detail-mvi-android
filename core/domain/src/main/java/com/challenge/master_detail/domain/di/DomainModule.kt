package com.challenge.master_detail.domain.di

import com.challenge.master_detail.domain.repository.ColorRepository
import com.challenge.master_detail.domain.repository.ColorRepositoryImpl
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
    fun provideHomeRepository(repository: ColorRepositoryImpl): ColorRepository = repository

}