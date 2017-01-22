package com.zxjdev.smile.data.moment.datasource;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.zxjdev.smile.data.moment.MomentEntity;
import com.zxjdev.smile.data.user.UserEntity;
import com.zxjdev.smile.data.exception.AuthorizationException;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

public class MomentCloudService implements IMomentCloudService {

    @Inject
    public MomentCloudService() {

    }

    public Observable<Void> addMoment(String content, UserEntity currentUser) {
        return Observable.create(subscriber -> {
            if (currentUser == null) {
                subscriber.onError(new AuthorizationException("用户未登录"));
                return;
            }
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

    public Observable<List<MomentEntity>> getMomentList(UserEntity currentUser) {
        return Observable.create(subscriber -> {
            if (currentUser == null) {
                subscriber.onError(new AuthorizationException("您没有登录"));
                return;
            }
            AVQuery<MomentEntity> query = AVObject.getQuery(MomentEntity.class);
            query.whereNotEqualTo("user", currentUser);
            try {
                subscriber.onNext(query.find());
                subscriber.onCompleted();
            } catch (AVException e) {
                subscriber.onError(e);
            }
        });
    }
}
