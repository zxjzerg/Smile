package com.zxjdev.smile.data.net;

import com.avos.avoscloud.AVException;
import com.zxjdev.smile.data.entity.MomentEntity;
import com.zxjdev.smile.data.entity.UserEntity;

import rx.Observable;

public class MomentService {

    /**
     * 发表一个“时刻”
     *
     * @param content 内容
     */
    public static Observable<Void> addMoment(String content, UserEntity currentUser) {
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
}
