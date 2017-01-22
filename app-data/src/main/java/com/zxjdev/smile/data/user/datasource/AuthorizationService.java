package com.zxjdev.smile.data.user.datasource;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.zxjdev.smile.data.user.UserEntity;

import javax.inject.Inject;

import rx.Observable;

public class AuthorizationService implements IAuthorizationCloudService {

    @Inject
    public AuthorizationService() {

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
    public Observable<UserEntity> login(String username, String password) {
        return Observable.create(subscriber -> {
            try {
                subscriber.onNext(AVUser.logIn(username, password, UserEntity.class));
            } catch (AVException e) {
                subscriber.onError(e);
            }
        });
    }

    @Override
    public Observable<Boolean> checkHasAuthorized() {
        return Observable.create(subscriber -> {
            subscriber.onNext(AVUser.getCurrentUser() != null);
        });
    }

    @Override
    public Observable<Void> logout() {
        return Observable.create(subscriber -> {
            AVUser.logOut();
            subscriber.onCompleted();
        });
    }
}
