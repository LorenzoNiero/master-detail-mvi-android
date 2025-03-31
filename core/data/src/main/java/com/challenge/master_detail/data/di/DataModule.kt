package com.challenge.master_detail.data.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
internal class DataModule {

//    @Provides
//    @Singleton
//    fun provideRemoteDataSource(localDataSourceImpl: TIPO ): TIPO_BASE = localDataSourceImpl
}