package com.zxjdev.smile.domain.authorization.usecase;

import com.zxjdev.smile.domain.authorization.AuthorizationRepository;
import com.zxjdev.smile.domain.communal.base.SchedulerFactory;
import com.zxjdev.smile.domain.communal.base.UseCase;

import rx.Observable;

public class Logout extends UseCase<Logout.RequestParams, Void> {

  private AuthorizationRepository authorizationRepository;

  public Logout(SchedulerFactory schedulerFactory, AuthorizationRepository authorizationRepository) {
    super(schedulerFactory);
    this.authorizationRepository = authorizationRepository;
  }

  @Override
  protected Observable<Void> buildUseCaseObservable(RequestParams params) {
    return authorizationRepository.logout();
  }

  public static class RequestParams implements UseCase.RequestParams {

  }
}
