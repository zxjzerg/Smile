package com.zxjdev.smile.domain.authorization;

import io.reactivex.Completable;
import io.reactivex.Observable;

public interface AuthorizationRepository {

  Completable register(String username, String password);

  Completable login(String username, String password);

  Observable<Boolean> checkIsLogined();

  Completable logout();
}
