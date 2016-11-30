package com.zxjdev.smile.data.repository;

import com.zxjdev.smile.data.entity.mapper.UserMapper;
import com.zxjdev.smile.data.repository.store.factory.UserDataStoreFactory;
import com.zxjdev.smile.data.repository.store.i.IUserDataStore;
import com.zxjdev.smile.domain.bo.User;
import com.zxjdev.smile.domain.repository.UserRepository;

import javax.inject.Inject;

import rx.Observable;

public class UserDataRepository implements UserRepository {

    private UserDataStoreFactory userDataStoreFactory;

    @Inject
    public UserDataRepository(UserDataStoreFactory userDataStoreFactory) {
        this.userDataStoreFactory = userDataStoreFactory;
    }

    @Override
    public Observable<Void> register(String username, String password) {
        IUserDataStore userDataStore = this.userDataStoreFactory.createCloudStore();
        return userDataStore.register(username, password);
    }

    @Override
    public Observable<User> login(String username, String password) {
        IUserDataStore userDataStore = this.userDataStoreFactory.createCloudStore();
        return userDataStore.login(username, password).map(UserMapper::transform);
    }

    @Override
    public Observable<Boolean> checkHasAuthorized() {
        IUserDataStore userDataStore = this.userDataStoreFactory.createCloudStore();
        return userDataStore.checkHasAuthorized();
    }

    @Override
    public Observable<Void> logout() {
        IUserDataStore userDataStore = this.userDataStoreFactory.createCloudStore();
        return userDataStore.logout();
    }
}