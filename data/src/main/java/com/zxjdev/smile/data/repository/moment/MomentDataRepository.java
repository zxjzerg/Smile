package com.zxjdev.smile.data.repository.moment;

import com.zxjdev.smile.domain.bo.Moment;
import com.zxjdev.smile.domain.repository.MomentRepository;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

public class MomentDataRepository implements MomentRepository {

    private MomentDataStoreFactory momentDataStoreFactory;

    @Inject
    public MomentDataRepository(MomentDataStoreFactory momentDataStoreFactory) {
        this.momentDataStoreFactory = momentDataStoreFactory;
    }

    @Override
    public Observable<Void> addMoment(String content) {
        return this.momentDataStoreFactory.createCloudStore().addMoment(content);
    }

    @Override
    public Observable<List<Moment>> queryMomentList() {
        return null;
    }

    @Override
    public Observable<Moment> queryMoment(String momentId) {
        return null;
    }
}
