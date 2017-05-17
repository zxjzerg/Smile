package com.zxjdev.smile.data.moment.datasource;

import com.zxjdev.smile.data.moment.entity.MomentEntity;

import java.util.List;

import rx.Observable;

public interface MomentCloudService {

    /**
     * Publish a moment
     *
     * @param content text content of moment
     */
    Observable<Void> addMoment(String content);

    /**
     * Get a list of moment
     *
     * @return A list of moment
     */
    Observable<List<MomentEntity>> getMomentList();
}
