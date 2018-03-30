package com.zxjdev.smile.domain.moment.usecase;

import com.zxjdev.smile.domain.common.base.DataUseCase;
import com.zxjdev.smile.domain.common.base.UseCaseRequestParams;
import com.zxjdev.smile.domain.moment.Moment;
import com.zxjdev.smile.domain.moment.MomentRepository;

import java.util.List;

import io.reactivex.Observable;

public class GetMomentList extends DataUseCase<GetMomentList.RequestParams, List<Moment>> {

  private MomentRepository momentRepository;

  public GetMomentList(MomentRepository momentRepository) {
    this.momentRepository = momentRepository;
  }

  @Override
  protected Observable<List<Moment>> buildUseCaseObservable(RequestParams params) {
    return momentRepository.queryMomentList();
  }

  public static class RequestParams implements UseCaseRequestParams {

  }
}