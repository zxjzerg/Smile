package com.zxjdev.smile.data.repository.store.factory;

import com.zxjdev.smile.data.repository.store.CloudMomentDataStore;
import com.zxjdev.smile.data.repository.store.i.IMomentDataStore;

import javax.inject.Inject;

public class MomentDataStoreFactory {

    @Inject
    public MomentDataStoreFactory() {

    }

    public IMomentDataStore createCloudStore() {
        return new CloudMomentDataStore();
    }
}
