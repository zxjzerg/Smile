package com.zxjdev.smile.data.repository.store.factory;

import com.zxjdev.smile.data.repository.store.CloudUserDataStore;
import com.zxjdev.smile.data.repository.store.i.IUserDataStore;

import javax.inject.Inject;

public class UserDataStoreFactory {

    @Inject
    public UserDataStoreFactory() {

    }

    public IUserDataStore createCloudStore() {
        return new CloudUserDataStore();
    }
}
