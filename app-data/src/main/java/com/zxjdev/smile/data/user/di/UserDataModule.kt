package com.zxjdev.smile.data.user.di

import com.avos.avoscloud.AVUser
import com.zxjdev.smile.data.authorization.AuthorizationException
import com.zxjdev.smile.data.user.UserDataRepository
import com.zxjdev.smile.data.user.datasource.UserCloudService
import com.zxjdev.smile.data.user.datasource.UserCloudServiceLeanCloudImpl
import com.zxjdev.smile.data.user.entity.UserEntity
import com.zxjdev.smile.domain.user.UserRepository
import dagger.Module
import dagger.Provides

@Module
class UserDataModule {

    @Provides
    internal fun provideCurrentUser(): UserEntity {
        val currentUser = AVUser.getCurrentUser(UserEntity::class.java)
        return currentUser ?: throw AuthorizationException("There is no user login.")
    }

    @Provides
    internal fun provideUserCloudService(userCloudService: UserCloudServiceLeanCloudImpl): UserCloudService {
        return userCloudService
    }

    @Provides
    internal fun provideUserRepository(userDataRepository: UserDataRepository): UserRepository {
        return userDataRepository
    }
}
