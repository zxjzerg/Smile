package com.zxjdev.smile.domain.authorization.usecase;

import com.zxjdev.smile.domain.authorization.AuthorizationRepository;
import com.zxjdev.smile.domain.common.base.JobUseCase;
import com.zxjdev.smile.domain.common.base.UseCaseRequestParams;

import io.reactivex.Completable;

public class Logout extends JobUseCase<Logout.RequestParams> {

  private AuthorizationRepository authorizationRepository;

  public Logout(AuthorizationRepository authorizationRepository) {
    this.authorizationRepository = authorizationRepository;
  }

  @Override
  protected Completable buildUseCaseObservable(RequestParams params) {
    return authorizationRepository.logout();
  }

  public static class RequestParams implements UseCaseRequestParams {

  }
}
