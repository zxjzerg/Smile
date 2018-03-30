package com.zxjdev.smile.domain.authorization.usecase;

import com.zxjdev.smile.domain.authorization.AuthorizationRepository;
import com.zxjdev.smile.domain.common.base.JobUseCase;
import com.zxjdev.smile.domain.common.base.UseCaseRequestParams;

import javax.inject.Inject;

import io.reactivex.Completable;

public class Login extends JobUseCase<Login.RequestParams> {

  private AuthorizationRepository authorizationRepository;

  @Inject
  public Login(AuthorizationRepository authorizationRepository) {
    this.authorizationRepository = authorizationRepository;
  }

  @Override
  protected Completable buildUseCaseObservable(RequestParams params) {
    return authorizationRepository.login(params.getUsername(), params.getPassword());
  }

  public static class RequestParams implements UseCaseRequestParams {

    private String username;
    private String password;

    public RequestParams(String username, String password) {
      this.username = username;
      this.password = password;
    }

    public String getUsername() {
      return username;
    }

    public String getPassword() {
      return password;
    }
  }
}
