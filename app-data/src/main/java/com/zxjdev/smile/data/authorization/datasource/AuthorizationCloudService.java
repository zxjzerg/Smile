package com.zxjdev.smile.data.authorization.datasource;

import io.reactivex.Observable;

public interface AuthorizationCloudService {

  Observable<Void> register(String username, String password);

  Observable<Void> login(String username, String password);

  Observable<Boolean> checkIsLogined();

  Observable<Void> logout();
}
