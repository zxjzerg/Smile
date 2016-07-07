package com.zxjdev.smile.data.net;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.zxjdev.smile.data.entity.UserEntity;

import rx.Observable;

public class AVCloudHelper {

    public static Observable<Void> register(String username, String password) {
        AVUser user = new AVUser();
        user.setUsername(username);
        user.setPassword(password);

        return Observable.create(subscriber -> {
            try {
                user.signUp();
                subscriber.onCompleted();
            } catch (AVException e) {
                subscriber.onError(e);
            }
        });
    }

    public static Observable<UserEntity> login(String username, String password) {
        return Observable.create(subscriber -> {
            try {
                subscriber.onNext(AVUser.logIn(username, password, UserEntity.class));
            } catch (AVException e) {
                subscriber.onError(e);
            }
        });
    }

    public static Observable<Boolean> checkHasAuthorized() {
        return Observable.create(subscriber -> {
            subscriber.onNext(AVUser.getCurrentUser() != null);
        });
    }
}
