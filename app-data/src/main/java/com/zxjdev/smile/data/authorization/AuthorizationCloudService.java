package com.zxjdev.smile.data.authorization;

import rx.Observable;

public interface AuthorizationCloudService {

  Observable<Void> register(String username, String password);

  Observable<Void> login(String username, String password);

  Observable<Boolean> checkIsLogined();
}
