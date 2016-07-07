package com.zxjdev.smile.data.repository.datastore;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;

import rx.Observable;

public class CloudUserDataStore implements UserDataStore {

    @Override
    public Observable<Void> register(String username, String password) {
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
}
