package com.zxjdev.smile.domain.moment.usecase;

import com.zxjdev.smile.domain.communal.base.SchedulerFactory;
import com.zxjdev.smile.domain.communal.base.UseCase;
import com.zxjdev.smile.domain.moment.Moment;
import com.zxjdev.smile.domain.moment.MomentRepository;

import java.util.List;

import rx.Observable;

public class GetMomentList extends UseCase<GetMomentList.RequestParams, List<Moment>> {

  private MomentRepository momentRepository;

  public GetMomentList(SchedulerFactory schedulerFactory, MomentRepository momentRepository) {
    super(schedulerFactory);
    this.momentRepository = momentRepository;
  }

  @Override
  protected Observable<List<Moment>> buildUseCaseObservable(RequestParams params) {
    return momentRepository.queryMomentList();
  }

  public static class RequestParams implements UseCase.RequestParams {

  }
}