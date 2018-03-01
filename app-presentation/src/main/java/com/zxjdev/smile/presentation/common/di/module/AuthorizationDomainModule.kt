package com.zxjdev.smile.presentation.common.di.module

import com.zxjdev.smile.data.authorization.di.AuthorizationDataModule
import com.zxjdev.smile.domain.authorization.AuthorizationRepository
import com.zxjdev.smile.domain.authorization.usecase.AutoLogin
import com.zxjdev.smile.domain.authorization.usecase.Login
import com.zxjdev.smile.domain.authorization.usecase.Logout
import com.zxjdev.smile.domain.authorization.usecase.Register

import dagger.Module
import dagger.Provides

@Module(includes = [AuthorizationDataModule::class])
class AuthorizationDomainModule {

    @Provides
    internal fun provideAutoLogin(repository: AuthorizationRepository): AutoLogin {
        return AutoLogin(repository)
    }

    @Provides
    internal fun provideLogin(repository: AuthorizationRepository): Login {
        return Login(repository)
    }

    @Provides
    internal fun provideLogout(repository: AuthorizationRepository): Logout {
        return Logout(repository)
    }

    @Provides
    internal fun provideRegister(repository: AuthorizationRepository): Register {
        return Register(repository)
    }
}
