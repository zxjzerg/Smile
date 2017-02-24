package com.zxjdev.smile.data.moment.datasource;

import com.zxjdev.smile.data.moment.MomentEntity;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

public class MomentCloudDataSource {

    private MomentCloudService momentService;

    @Inject
    public MomentCloudDataSource(MomentCloudService momentService) {
        this.momentService = momentService;
    }

    public Observable<Void> addMoment(String content) {
        return momentService.addMoment(content);
    }

    public Observable<List<MomentEntity>> getMomentList() {
        return momentService.getMomentList();
    }
}
