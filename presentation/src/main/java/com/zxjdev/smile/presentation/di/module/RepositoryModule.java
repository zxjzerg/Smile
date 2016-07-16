package com.zxjdev.smile.presentation.di.module;

import com.zxjdev.smile.data.repository.MomentDataRepository;
import com.zxjdev.smile.data.repository.store.factory.MomentDataStoreFactory;
import com.zxjdev.smile.data.repository.UserDataRepository;
import com.zxjdev.smile.data.repository.store.factory.UserDataStoreFactory;
import com.zxjdev.smile.domain.repository.MomentRepository;
import com.zxjdev.smile.domain.repository.UserRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    public UserRepository provideUserRepository(UserDataStoreFactory userDataStoreFactory) {
        return new UserDataRepository(userDataStoreFactory);
    }

    @Provides
    public MomentRepository provideMomentRepository(MomentDataStoreFactory momentDataStoreFactory) {
        return new MomentDataRepository(momentDataStoreFactory);
    }
}
