package com.zxjdev.smile.data.repository.datastore;

import rx.Observable;

public interface UserDataStore {

    Observable<Void> register(String username, String password);
}
