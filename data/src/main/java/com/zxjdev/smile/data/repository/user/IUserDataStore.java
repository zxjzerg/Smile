package com.zxjdev.smile.data.repository.user;

import com.zxjdev.smile.data.entity.UserEntity;

import rx.Observable;

public interface IUserDataStore {

    Observable<Void> register(String username, String password);

    Observable<UserEntity> login(String username, String password);

    Observable<Boolean> checkHasAuthorized();

    Observable<Void> logout();
}
