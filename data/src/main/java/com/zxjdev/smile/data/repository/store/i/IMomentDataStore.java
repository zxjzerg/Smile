package com.zxjdev.smile.data.repository.store.i;

import rx.Observable;

public interface IMomentDataStore {

    Observable<Void> addMoment(String content);
}
