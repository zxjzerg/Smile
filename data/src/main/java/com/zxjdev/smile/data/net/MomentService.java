package com.zxjdev.smile.data.net;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.zxjdev.smile.data.entity.MomentEntity;
import com.zxjdev.smile.data.entity.UserEntity;
import com.zxjdev.smile.data.exception.AuthorizationException;

import java.util.List;

import rx.Observable;

public class MomentService {

    /**
     * 发表一个“时刻”
     *
     * @param content 内容
     */
    public static Observable<Void> addMoment(String content, UserEntity currentUser) {
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

    /**
     * 获取用户发的“时刻”
     *
     * @param currentUser 当前登录的用户
     * @return 用户发的“时刻”列表
     */
    public static Observable<List<MomentEntity>> getMomentList(UserEntity currentUser) {
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
