package com.zxjdev.smile.data.repository.moment;

import javax.inject.Inject;

public class MomentDataStoreFactory {

    @Inject
    public MomentDataStoreFactory() {

    }

    public IMomentDataStore createCloudStore() {
        return new CloudMomentDataStore();
    }
}
