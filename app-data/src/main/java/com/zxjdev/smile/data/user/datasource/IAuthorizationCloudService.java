package com.zxjdev.smile.data.user.datasource;

import com.zxjdev.smile.data.user.UserEntity;

import rx.Observable;

public interface IAuthorizationCloudService {

    Observable<Void> register(String username, String password);

    Observable<UserEntity> login(String username, String password);

    /**
     * Check if user is login
     *
     * @return true if is login, false is not
     */
    Observable<Boolean> checkHasAuthorized();

    Observable<Void> logout();
}
