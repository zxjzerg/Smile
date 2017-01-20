package com.zxjdev.smile.data.moment;

import com.zxjdev.smile.data.common.InternalDataStore;

import javax.inject.Inject;

import rx.Observable;

public class MomentCloudDataStore {

    private IMomentService momentService;

    @Inject
    public MomentCloudDataStore(IMomentService momentService) {
        this.momentService = momentService;
    }

    public Observable<Void> addMoment(String content) {
        return momentService.addMoment(content, InternalDataStore.getCurrentUser());
    }
}
