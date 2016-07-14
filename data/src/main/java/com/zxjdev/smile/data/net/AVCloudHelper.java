package com.zxjdev.smile.data.net;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.zxjdev.smile.data.entity.MomentEntity;
import com.zxjdev.smile.data.entity.UserEntity;

import rx.Observable;

public class AVCloudHelper {

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

    /**
     * 获取当前登录的用户
     *
     * @return 当前登录的用户对象
     */
    public static UserEntity getCurrentUser() {
        return AVUser.getCurrentUser(UserEntity.class);
    }

    /**
     * 发表一个“时刻”
     *
     * @param content 内容
     */
    public static Observable<Void> addMoment(String content) {
        return Observable.create(subscriber -> {
            MomentEntity momentEntity = new MomentEntity();
            momentEntity.setContent(content);
            momentEntity.setOwner(getCurrentUser());
            try {
                momentEntity.save();
                subscriber.onCompleted();
            } catch (AVException e) {
                subscriber.onError(e);
            }
        });
    }
}
