package com.challenge.master_detail.data.di

import com.challenge.master_detail.data.datasource.ColorLocalDataSource
import com.challenge.master_detail.data.datasource.ColorLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal class DataModule {

    @Provides
    @Singleton
    fun provideBreedLocalDataSource(localDataSourceImpl: ColorLocalDataSourceImpl): ColorLocalDataSource = localDataSourceImpl
}