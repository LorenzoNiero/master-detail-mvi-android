package com.challenge.master_detail.navigator.di

import com.challenge.master_detail.navigator.Navigator
import com.challenge.master_detail.navigator.NavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class NavigatorModule {
    @Binds
    abstract fun navigator(navigator: NavigatorImpl): Navigator
}
