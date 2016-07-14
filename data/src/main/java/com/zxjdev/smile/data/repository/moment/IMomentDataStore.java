package com.zxjdev.smile.data.repository.moment;

import rx.Observable;

public interface IMomentDataStore {

    Observable<Void> addMoment(String content);
}
