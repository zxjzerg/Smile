package com.zxjdev.smile.domain.moment;

import java.util.List;

import rx.Observable;

public interface MomentRepository {

  Observable<Void> addMoment(String content);

  Observable<List<Moment>> queryMomentList();

  Observable<Moment> queryMoment(String momentId);
}
