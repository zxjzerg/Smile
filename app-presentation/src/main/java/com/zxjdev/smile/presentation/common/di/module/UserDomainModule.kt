package com.zxjdev.smile.presentation.common.di.module

import com.zxjdev.smile.data.user.di.UserDataModule
import com.zxjdev.smile.domain.user.UserRepository
import com.zxjdev.smile.domain.user.usecase.GetCurrentUser
import com.zxjdev.smile.domain.user.usecase.UploadAvatar

import dagger.Module
import dagger.Provides

@Module(includes = arrayOf(UserDataModule::class))
class UserDomainModule {

    @Provides
    internal fun provideGetCurrentUser(userRepository: UserRepository): GetCurrentUser {
        return GetCurrentUser(userRepository)
    }

    @Provides
    internal fun provideUploadAvatar(userRepository: UserRepository): UploadAvatar {
        return UploadAvatar(userRepository)
    }
}
