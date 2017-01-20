package com.zxjdev.smile.data.user;

import rx.Observable;

public interface IAuthorizationService {

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
