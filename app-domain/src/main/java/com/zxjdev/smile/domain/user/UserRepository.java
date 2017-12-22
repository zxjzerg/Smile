package com.zxjdev.smile.domain.user;

import io.reactivex.Observable;

public interface UserRepository {

  Observable<User> getUser(String id);

  Observable<User> getCurrentUser();

  Observable<String> uploadAvatar(String localPath);
}
