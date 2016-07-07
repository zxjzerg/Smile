package com.zxjdev.smile.domain.repository;

import rx.Observable;

public interface UserRepository {

    Observable<Void> register(String username, String password);
}
