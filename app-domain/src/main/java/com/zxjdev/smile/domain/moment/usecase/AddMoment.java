package com.zxjdev.smile.domain.moment.usecase;

import com.zxjdev.smile.domain.common.base.JobUseCase;
import com.zxjdev.smile.domain.common.base.UseCase;
import com.zxjdev.smile.domain.common.base.UseCaseRequestParams;
import com.zxjdev.smile.domain.moment.MomentRepository;

import io.reactivex.Completable;
import io.reactivex.Observable;

public class AddMoment extends JobUseCase<AddMoment.RequestParams> {

  private MomentRepository momentRepository;

  public AddMoment(MomentRepository momentRepository) {
    this.momentRepository = momentRepository;
  }

  @Override
  protected Completable buildUseCaseObservable(RequestParams params) {
    return momentRepository.addMoment(params.getContent());
  }

  public static class RequestParams implements UseCaseRequestParams {

    private String content;

    public RequestParams(String content) {
      this.content = content;
    }

    public String getContent() {
      return content;
    }
  }
}
