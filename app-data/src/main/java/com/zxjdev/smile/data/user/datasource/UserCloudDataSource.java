package com.zxjdev.smile.data.user.datasource;

import com.zxjdev.smile.data.user.UserEntity;
import com.zxjdev.smile.data.utils.LeanCloudUtils;

import javax.inject.Inject;

import rx.Observable;

/**
 * 负责云端用户数据的处理
 *
 * @author Andrew
 */
public class UserCloudDataSource {

    private UserCloudService userCloudService;

    @Inject
    public UserCloudDataSource(UserCloudService userCloudService) {
        this.userCloudService = userCloudService;
    }

    public Observable<Void> register(String username, String password) {
        return userCloudService.register(username, password);
    }

    public Observable<UserEntity> login(String username, String password) {
        return userCloudService.login(username, password);
    }

    public Observable<Boolean> checkHasAuthorized() {
        return userCloudService.checkHasAuthorized();
    }

    public Observable<Void> logout() {
        return userCloudService.logout();
    }

    public Observable<UserEntity> getUser(String id) {
        if (id == null) {
            return Observable.just(LeanCloudUtils.getCurrentUser());
        } else {
            return Observable.empty();
        }
    }

    public Observable<String> uploadAvatar(String localPath) {
        return userCloudService.uploadAvatar(localPath);
    }
}
