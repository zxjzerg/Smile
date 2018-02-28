package com.zxjdev.smile.domain.authorization.usecase;

import com.zxjdev.smile.domain.authorization.AuthorizationRepository;
import com.zxjdev.smile.domain.common.base.UseCase;

import io.reactivex.Observable;

public class Logout extends UseCase<Logout.RequestParams, Void> {

  private AuthorizationRepository authorizationRepository;

  public Logout(AuthorizationRepository authorizationRepository) {
    this.authorizationRepository = authorizationRepository;
  }

  @Override
  protected Observable<Void> buildUseCaseObservable(RequestParams params) {
    return authorizationRepository.logout();
  }

  public static class RequestParams implements UseCase.RequestParams {

  }
}
