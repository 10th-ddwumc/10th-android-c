package com.yogurt.umc_work02.di

import android.content.Context
import com.yogurt.umc_work02.data.local.datastore.ItemDataStore
import com.yogurt.umc_work02.data.remote.RetrofitClient
import com.yogurt.umc_work02.data.repository.UserLocalRepository
import com.yogurt.umc_work02.data.repository.UserRemoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideUserLocalRepository (
        @ApplicationContext context: Context
    ): UserLocalRepository {
        val itemDataStore = ItemDataStore(context)
        return UserLocalRepository(itemDataStore)

    }

    @Provides
    @Singleton
    fun provideUserRemoteRepository (
          @ApplicationContext context: Context
    ): UserRemoteRepository {
        return UserRemoteRepository(RetrofitClient.authService)

    }
}