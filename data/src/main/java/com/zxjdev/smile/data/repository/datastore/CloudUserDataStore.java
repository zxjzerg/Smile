package com.zxjdev.smile.data.repository.datastore;

import com.zxjdev.smile.data.entity.UserEntity;
import com.zxjdev.smile.data.net.AVCloudHelper;

import rx.Observable;

/**
 * 负责云端用户数据的处理
 *
 * @author Andrew
 */
public class CloudUserDataStore implements UserDataStore {

    @Override
    public Observable<Void> register(String username, String password) {
        return AVCloudHelper.register(username, password);
    }

    @Override
    public Observable<UserEntity> login(String username, String password) {
        return AVCloudHelper.login(username, password);
    }

    @Override
    public Observable<Boolean> checkHasAuthorized() {
        return AVCloudHelper.checkHasAuthorized();
    }

    @Override
    public Observable<Void> logout() {
        return AVCloudHelper.logout();
    }
}
