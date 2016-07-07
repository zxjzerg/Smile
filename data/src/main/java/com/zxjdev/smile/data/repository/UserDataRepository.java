package com.zxjdev.smile.data.repository;

import com.zxjdev.smile.data.repository.datastore.CloudUserDataStore;
import com.zxjdev.smile.data.repository.datastore.UserDataStore;
import com.zxjdev.smile.domain.repository.UserRepository;

import rx.Observable;

public class UserDataRepository implements UserRepository {

    @Override
    public Observable<Void> register(String username, String password) {
        UserDataStore userDataStore = new CloudUserDataStore();
        return userDataStore.register(username, password);
    }
}
