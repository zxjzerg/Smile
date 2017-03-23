package com.zxjdev.smile.data.di;

import com.avos.avoscloud.AVUser;
import com.zxjdev.smile.data.exception.AuthorizationException;
import com.zxjdev.smile.data.user.UserEntity;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Provides
    UserEntity provideCurrentUser() {
        UserEntity currentUser = AVUser.getCurrentUser(UserEntity.class);
        if (currentUser != null) {
            return currentUser;
        } else {
            throw new AuthorizationException("There is no user login.");
        }
    }
}
