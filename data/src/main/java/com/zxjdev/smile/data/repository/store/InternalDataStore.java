package com.zxjdev.smile.data.repository.store;

import com.avos.avoscloud.AVUser;
import com.zxjdev.smile.data.entity.UserEntity;

public class InternalDataStore {

    /**
     * 获取当前登录的用户
     *
     * @return 当前登录的用户对象
     */
    public static UserEntity getCurrentUser() {
        return AVUser.getCurrentUser(UserEntity.class);
    }
}
