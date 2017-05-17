package com.zxjdev.smile.data.moment.datasource;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.zxjdev.smile.data.BuildConfig;
import com.zxjdev.smile.data.moment.entity.MomentEntity;
import com.zxjdev.smile.data.user.entity.UserEntity;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

public class MomentCloudServiceLeanCloudImpl implements MomentCloudService {

    private UserEntity currentUser;

    @Inject
    public MomentCloudServiceLeanCloudImpl(UserEntity currentUser) {
        this.currentUser = currentUser;
    }

    @Override
    public Observable<Void> addMoment(String content) {
        return Observable.create(subscriber -> {
            MomentEntity momentEntity = new MomentEntity();
            momentEntity.setContent(content);
            momentEntity.setOwner(currentUser);
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
            query.whereEqualTo("user", currentUser);
            query.include("user");
            query.limit(BuildConfig.QUERY_LIMIT);
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
