package com.zxjdev.smile.domain.authorization;

import rx.Observable;

public interface AuthorizationRepository {

  Observable<Void> register(String username, String password);

  Observable<Void> login(String username, String password);

  Observable<Boolean> checkIsLogined();

  Observable<Void> logout();
}
