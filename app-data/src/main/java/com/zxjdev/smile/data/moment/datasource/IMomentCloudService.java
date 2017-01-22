package com.zxjdev.smile.data.moment.datasource;

import com.zxjdev.smile.data.moment.MomentEntity;
import com.zxjdev.smile.data.user.UserEntity;

import java.util.List;

import rx.Observable;

public interface IMomentCloudService {

    /**
     * 发表一个“时刻”
     *
     * @param content 内容
     */
    Observable<Void> addMoment(String content, UserEntity currentUser);

    /**
     * 获取用户发的“时刻”
     *
     * @param currentUser 当前登录的用户
     * @return 用户发的“时刻”列表
     */
    Observable<List<MomentEntity>> getMomentList(UserEntity currentUser);
}
