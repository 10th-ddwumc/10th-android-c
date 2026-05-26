package com.yogurt.umc_nike_clone_compose.di

import android.content.Context
import com.yogurt.umc_nike_clone_compose.data.local.datastore.ItemDataStore
import com.yogurt.umc_nike_clone_compose.data.remote.AuthService
import com.yogurt.umc_nike_clone_compose.data.remote.RetrofitClient
import com.yogurt.umc_nike_clone_compose.data.repository.UserLocalRepository
import com.yogurt.umc_nike_clone_compose.data.repository.UserRemoteRepository
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
    fun provideAuthService(): AuthService {
        return RetrofitClient.authService
    }

    @Provides
    @Singleton
    fun provideUserRemoteRepository(authService: AuthService): UserRemoteRepository {
        return UserRemoteRepository(authService)
    }

    @Provides
    @Singleton
    fun provideUserLocalRepository(
        @ApplicationContext context: Context
    ): UserLocalRepository {
        val itemDataStore = ItemDataStore(context)
        return UserLocalRepository(itemDataStore)
    }
}
