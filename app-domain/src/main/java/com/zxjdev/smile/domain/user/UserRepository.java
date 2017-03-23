package com.zxjdev.smile.domain.user;

import rx.Observable;

public interface UserRepository {

  Observable<Void> register(String username, String password);

  Observable<User> login(String username, String password);

  Observable<Boolean> checkHasAuthorized();

  Observable<Void> logout();

  Observable<User> getUser(String id);

  Observable<User> getCurrentUser();

  Observable<String> uploadAvatar(String localPath);
}
