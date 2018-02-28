package com.zxjdev.smile.domain.authorization.usecase;

import com.zxjdev.smile.domain.authorization.AuthorizationRepository;
import com.zxjdev.smile.domain.common.base.UseCase;

import io.reactivex.Observable;

public class AutoLogin extends UseCase<AutoLogin.RequestParams, Boolean> {

  private AuthorizationRepository authorizationRepository;

  public AutoLogin(AuthorizationRepository authorizationRepository) {
    this.authorizationRepository = authorizationRepository;
  }

  @Override
  protected Observable<Boolean> buildUseCaseObservable(RequestParams params) {
    return authorizationRepository.checkIsLogined();
  }

  public static class RequestParams implements UseCase.RequestParams {

  }
}