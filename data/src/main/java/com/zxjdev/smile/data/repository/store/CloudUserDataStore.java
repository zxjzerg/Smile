package com.zxjdev.smile.data.repository.store;

import com.zxjdev.smile.data.entity.UserEntity;
import com.zxjdev.smile.data.net.AuthorizationService;
import com.zxjdev.smile.data.repository.store.i.IUserDataStore;

import rx.Observable;

/**
 * 负责云端用户数据的处理
 *
 * @author Andrew
 */
public class CloudUserDataStore implements IUserDataStore {

    @Override
    public Observable<Void> register(String username, String password) {
        return AuthorizationService.register(username, password);
    }

    @Override
    public Observable<UserEntity> login(String username, String password) {
        return AuthorizationService.login(username, password);
    }

    @Override
    public Observable<Boolean> checkHasAuthorized() {
        return AuthorizationService.checkHasAuthorized();
    }

    @Override
    public Observable<Void> logout() {
        return AuthorizationService.logout();
    }
}
