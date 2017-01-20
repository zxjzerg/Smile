package com.zxjdev.smile.data.user;

import com.zxjdev.smile.domain.user.User;
import com.zxjdev.smile.domain.user.UserRepository;

import javax.inject.Inject;

import rx.Observable;

public class UserDataRepository implements UserRepository {

    private UserCloudDataStore userCloudDataStore;
    private UserMapper userMapper;

    @Inject
    public UserDataRepository(UserCloudDataStore userCloudDataStore, UserMapper userMapper) {
        this.userCloudDataStore = userCloudDataStore;
        this.userMapper = userMapper;
    }

    @Override
    public Observable<Void> register(String username, String password) {
        return userCloudDataStore.register(username, password);
    }

    @Override
    public Observable<User> login(String username, String password) {
        return userCloudDataStore.login(username, password).map(userMapper::transform);
    }

    @Override
    public Observable<Boolean> checkHasAuthorized() {
        return userCloudDataStore.checkHasAuthorized();
    }

    @Override
    public Observable<Void> logout() {
        return userCloudDataStore.logout();
    }
}