package com.zxjdev.smile.data.authorization.di

import com.zxjdev.smile.data.authorization.AuthorizationDataRepository
import com.zxjdev.smile.data.authorization.datasource.AuthorizationCloudService
import com.zxjdev.smile.data.authorization.datasource.AuthorizationCloudServiceLeanCloudImpl
import com.zxjdev.smile.domain.authorization.AuthorizationRepository

import dagger.Module
import dagger.Provides

@Module
class AuthorizationDataModule {

    @Provides
    internal fun provideCloudService(cloudService: AuthorizationCloudServiceLeanCloudImpl): AuthorizationCloudService {
        return cloudService
    }

    @Provides
    internal fun provideRepository(repository: AuthorizationDataRepository): AuthorizationRepository {
        return repository
    }
}
