package com.zxjdev.smile.data.repository.store;

import com.zxjdev.smile.data.net.MomentService;
import com.zxjdev.smile.data.repository.store.i.IMomentDataStore;

import rx.Observable;

public class CloudMomentDataStore implements IMomentDataStore {

    @Override
    public Observable<Void> addMoment(String content) {
        return MomentService.addMoment(content, InternalDataStore.getCurrentUser());
    }
}
