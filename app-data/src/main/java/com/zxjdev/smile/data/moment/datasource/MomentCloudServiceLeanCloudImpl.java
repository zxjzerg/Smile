package com.zxjdev.smile.data.moment.datasource;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.zxjdev.smile.data.BuildConfig;
import com.zxjdev.smile.data.moment.entity.MomentEntity;
import com.zxjdev.smile.data.user.entity.UserEntity;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class MomentCloudServiceLeanCloudImpl implements MomentCloudService {

  private UserEntity currentUser;

  @Inject
  public MomentCloudServiceLeanCloudImpl(UserEntity currentUser) {
    this.currentUser = currentUser;
  }

  @Override
  public Observable<Void> addMoment(String content) {
    return Observable.create(emitter -> {
      MomentEntity momentEntity = new MomentEntity();
      momentEntity.setContent(content);
      momentEntity.setOwner(currentUser);
      try {
        momentEntity.save();
        emitter.onComplete();
      } catch (AVException e) {
        emitter.tryOnError(e);
      }
    });
  }

  @Override
  public Observable<List<MomentEntity>> getMomentList() {
    return Observable.create(emitter -> {
      AVQuery<MomentEntity> query = AVObject.getQuery(MomentEntity.class);
      query.whereEqualTo("user", currentUser);
      query.include("user");
      query.limit(BuildConfig.QUERY_LIMIT);
      query.orderByDescending("createdAt");
      try {
        emitter.onNext(query.find());
        emitter.onComplete();
      } catch (AVException e) {
        emitter.tryOnError(e);
      }
    });
  }
}
