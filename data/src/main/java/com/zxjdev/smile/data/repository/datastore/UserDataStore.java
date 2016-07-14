package com.zxjdev.smile.data.repository.datastore;

import com.zxjdev.smile.data.entity.UserEntity;

import rx.Observable;

public interface UserDataStore {

    Observable<Void> register(String username, String password);

    Observable<UserEntity> login(String username, String password);

    Observable<Boolean> checkHasAuthorized();

    Observable<Void> logout();
}
