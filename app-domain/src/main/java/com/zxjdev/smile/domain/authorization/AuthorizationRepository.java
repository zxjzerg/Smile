package com.zxjdev.smile.domain.authorization;

import com.zxjdev.smile.domain.user.User;

import rx.Observable;

public interface AuthorizationRepository {

  Observable<Void> register(String username, String password);

  Observable<User> login(String username, String password);

  Observable<Boolean> checkIsLogined();
}
