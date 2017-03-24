package com.zxjdev.smile.data.user.datasource;

import rx.Observable;

public interface UserCloudService {

  Observable<String> uploadAvatar(String localPath);
}
