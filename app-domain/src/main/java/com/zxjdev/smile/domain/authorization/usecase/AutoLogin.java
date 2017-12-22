package com.zxjdev.smile.domain.authorization.usecase;

import com.zxjdev.smile.domain.authorization.AuthorizationRepository;
import com.zxjdev.smile.domain.common.SchedulerFactory;
import com.zxjdev.smile.domain.common.base.UseCase;

import io.reactivex.Observable;

public class AutoLogin extends UseCase<AutoLogin.RequestParams, Boolean> {

  private AuthorizationRepository authorizationRepository;

  public AutoLogin(SchedulerFactory schedulerFactory, AuthorizationRepository authorizationRepository) {
    super(schedulerFactory);
    this.authorizationRepository = authorizationRepository;
  }

  @Override
  protected Observable<Boolean> buildUseCaseObservable(RequestParams params) {
    return authorizationRepository.checkIsLogined();
  }

  public static class RequestParams implements UseCase.RequestParams {

  }
}