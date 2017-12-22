package com.zxjdev.smile.data.user.datasource;

import io.reactivex.Observable;

public interface UserCloudService {

  Observable<String> uploadAvatar(String localPath);
}
