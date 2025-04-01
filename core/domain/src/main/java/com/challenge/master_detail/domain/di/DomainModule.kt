package com.challenge.master_detail.domain.di

import com.challenge.master_detail.domain.repository.Repository
import com.challenge.master_detail.domain.repository.RepositoryImpl
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
    fun provideRepository(repository: RepositoryImpl): Repository = repository

}