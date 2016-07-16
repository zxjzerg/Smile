package com.zxjdev.smile.data.net;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.zxjdev.smile.data.entity.UserEntity;

import rx.Observable;

public class AuthorizationService {

    /**
     * 注册
     *
     * @param username 用户名
     * @param password 密码
     */
    public static Observable<Void> register(String username, String password) {
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

    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     */
    public static Observable<UserEntity> login(String username, String password) {
        return Observable.create(subscriber -> {
            try {
                subscriber.onNext(AVUser.logIn(username, password, UserEntity.class));
            } catch (AVException e) {
                subscriber.onError(e);
            }
        });
    }

    /**
     * 检查是否已经登录
     */
    public static Observable<Boolean> checkHasAuthorized() {
        return Observable.create(subscriber -> {
            subscriber.onNext(AVUser.getCurrentUser() != null);
        });
    }

    /**
     * 退出登录
     */
    public static Observable<Void> logout() {
        return Observable.create(subscriber -> {
            AVUser.logOut();
            subscriber.onCompleted();
        });
    }
}
