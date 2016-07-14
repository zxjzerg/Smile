package com.zxjdev.smile.domain.repository;

import com.zxjdev.smile.domain.bo.User;

import rx.Observable;

public interface UserRepository {

    Observable<Void> register(String username, String password);

    Observable<User> login(String username, String password);

    /** 检查是否已经在本机登录了 */
    Observable<Boolean> checkHasAuthorized();

    Observable<Void> logout();
}
