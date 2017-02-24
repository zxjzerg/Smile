package com.zxjdev.smile.data.moment.datasource;

import com.zxjdev.smile.data.moment.MomentEntity;

import java.util.List;

import rx.Observable;

public interface MomentCloudService {

    /**
     * 发表一个“时刻”
     *
     * @param content 内容
     */
    Observable<Void> addMoment(String content);

    /**
     * 获取用户发的“时刻”
     *
     * @return 用户发的“时刻”列表
     */
    Observable<List<MomentEntity>> getMomentList();
}
