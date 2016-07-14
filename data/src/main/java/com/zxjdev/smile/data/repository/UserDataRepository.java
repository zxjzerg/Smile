package com.zxjdev.smile.data.repository;

import com.zxjdev.smile.data.entity.mapper.UserMapper;
import com.zxjdev.smile.data.repository.datastore.CloudUserDataStore;
import com.zxjdev.smile.data.repository.datastore.UserDataStore;
import com.zxjdev.smile.domain.bo.User;
import com.zxjdev.smile.domain.repository.UserRepository;

import rx.Observable;

public class UserDataRepository implements UserRepository {

    @Override
    public Observable<Void> register(String username, String password) {
        UserDataStore userDataStore = new CloudUserDataStore();
        return userDataStore.register(username, password);
    }

    @Override
    public Observable<User> login(String username, String password) {
        UserDataStore userDataStore = new CloudUserDataStore();
        return userDataStore.login(username, password).map(UserMapper::transform);
    }

    @Override
    public Observable<Boolean> checkHasAuthorized() {
        UserDataStore userDataStore = new CloudUserDataStore();
        return userDataStore.checkHasAuthorized();
    }

    @Override
    public Observable<Void> logout() {
        UserDataStore userDataStore = new CloudUserDataStore();
        return userDataStore.logout();
    }
}