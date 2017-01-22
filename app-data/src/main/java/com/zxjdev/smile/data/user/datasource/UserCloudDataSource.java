package com.zxjdev.smile.data.user.datasource;

import com.zxjdev.smile.data.user.UserEntity;

import javax.inject.Inject;

import rx.Observable;

/**
 * 负责云端用户数据的处理
 *
 * @author Andrew
 */
public class UserCloudDataSource {

    private IAuthorizationCloudService authorizationService;

    @Inject
    public UserCloudDataSource(IAuthorizationCloudService authorizationService) {
        this.authorizationService = authorizationService;
    }

    public Observable<Void> register(String username, String password) {
        return authorizationService.register(username, password);
    }

    public Observable<UserEntity> login(String username, String password) {
        return authorizationService.login(username, password);
    }

    public Observable<Boolean> checkHasAuthorized() {
        return authorizationService.checkHasAuthorized();
    }

    public Observable<Void> logout() {
        return authorizationService.logout();
    }
}
