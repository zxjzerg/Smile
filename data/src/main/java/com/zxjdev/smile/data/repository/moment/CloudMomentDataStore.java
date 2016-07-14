package com.zxjdev.smile.data.repository.moment;

import com.zxjdev.smile.data.net.AVCloudHelper;

import rx.Observable;

public class CloudMomentDataStore implements IMomentDataStore {

    @Override
    public Observable<Void> addMoment(String content) {
        return AVCloudHelper.addMoment(content);
    }
}
