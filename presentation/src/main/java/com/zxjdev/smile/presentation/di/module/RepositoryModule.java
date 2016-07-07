package com.zxjdev.smile.presentation.di.module;

import com.zxjdev.smile.data.repository.UserDataRepository;
import com.zxjdev.smile.domain.repository.UserRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    UserRepository provideUserRepository() {
        return new UserDataRepository();
    }
}
