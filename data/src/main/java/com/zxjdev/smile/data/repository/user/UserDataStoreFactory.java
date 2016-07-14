package com.zxjdev.smile.data.repository.user;

import javax.inject.Inject;

public class UserDataStoreFactory {

    @Inject
    public UserDataStoreFactory() {

    }

    public IUserDataStore createCloudStore() {
        return new CloudUserDataStore();
    }
}
