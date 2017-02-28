package com.zxjdev.smile.data.moment.datasource;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.zxjdev.smile.data.moment.MomentEntity;
import com.zxjdev.smile.data.utils.LeanCloudUtils;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

public class MomentCloudServiceLeanCloudImpl implements MomentCloudService {

    @Inject
    public MomentCloudServiceLeanCloudImpl() {

    }

    @Override
    public Observable<Void> addMoment(String content) {
        return Observable.create(subscriber -> {
            MomentEntity momentEntity = new MomentEntity();
            momentEntity.setContent(content);
            momentEntity.setOwner(LeanCloudUtils.getCurrentUser());
            try {
                momentEntity.save();
                subscriber.onCompleted();
            } catch (AVException e) {
                subscriber.onError(e);
            }
        });
    }

    @Override
    public Observable<List<MomentEntity>> getMomentList() {
        return Observable.create(subscriber -> {
            AVQuery<MomentEntity> query = AVObject.getQuery(MomentEntity.class);
            query.whereEqualTo("user", LeanCloudUtils.getCurrentUser());
            query.include("user");
            query.limit(LeanCloudUtils.QUERY_LIMIT);
            query.orderByDescending("createdAt");
            try {
                subscriber.onNext(query.find());
                subscriber.onCompleted();
            } catch (AVException e) {
                subscriber.onError(e);
            }
        });
    }
}
