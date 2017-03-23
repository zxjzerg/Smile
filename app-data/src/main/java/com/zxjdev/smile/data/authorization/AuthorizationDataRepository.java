package com.zxjdev.smile.data.authorization;

import com.zxjdev.smile.domain.authorization.AuthorizationRepository;
import com.zxjdev.smile.domain.user.User;

import rx.Observable;

public class AuthorizationDataRepository implements AuthorizationRepository {

    @Override
    public Observable<Void> register(String username, String password) {
        return null;
    }

    @Override
    public Observable<User> login(String username, String password) {
        return null;
    }

    @Override
    public Observable<Boolean> checkIsLogined() {
        return null;
    }
}
