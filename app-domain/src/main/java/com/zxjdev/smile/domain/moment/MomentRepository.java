package com.zxjdev.smile.domain.moment;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

public interface MomentRepository {

  Completable addMoment(String content);

  Observable<List<Moment>> queryMomentList();

  Observable<Moment> queryMoment(String momentId);
}
