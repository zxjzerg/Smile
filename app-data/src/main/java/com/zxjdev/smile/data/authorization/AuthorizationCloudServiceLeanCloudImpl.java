package com.zxjdev.smile.data.authorization;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.zxjdev.smile.data.user.UserEntity;

import javax.inject.Inject;

import rx.Observable;

public class AuthorizationCloudServiceLeanCloudImpl implements AuthorizationCloudService {

    @Inject
    public AuthorizationCloudServiceLeanCloudImpl() {

    }

    @Override
    public Observable<Void> register(String username, String password) {
        return Observable.create(subscriber -> {
            AVUser user = new AVUser();
            user.setUsername(username);
            user.setPassword(password);
            try {
                user.signUp();
                subscriber.onCompleted();
            } catch (AVException e) {
                subscriber.onError(e);
            }
        });
    }

    @Override
    public Observable<Void> login(String username, String password) {
        return Observable.create(subscriber -> {
            try {
                AVUser.logIn(username, password, UserEntity.class);
                subscriber.onCompleted();
            } catch (AVException e) {
                subscriber.onError(e);
            }
        });
    }

    @Override
    public Observable<Boolean> checkIsLogined() {
        return Observable.create(subscriber -> {
            subscriber.onNext(AVUser.getCurrentUser() != null);
        });
    }
}
