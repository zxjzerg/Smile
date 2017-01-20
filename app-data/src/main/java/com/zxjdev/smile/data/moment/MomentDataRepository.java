package com.zxjdev.smile.data.moment;

import com.zxjdev.smile.domain.moment.Moment;
import com.zxjdev.smile.domain.moment.MomentRepository;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

public class MomentDataRepository implements MomentRepository {

    private MomentCloudDataStore momentCloudDataStore;

    @Inject
    public MomentDataRepository(MomentCloudDataStore momentCloudDataStore) {
        this.momentCloudDataStore = momentCloudDataStore;
    }

    @Override
    public Observable<Void> addMoment(String content) {
        return momentCloudDataStore.addMoment(content);
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
