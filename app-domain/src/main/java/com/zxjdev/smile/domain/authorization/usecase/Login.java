package com.zxjdev.smile.domain.authorization.usecase;

import com.zxjdev.smile.domain.authorization.AuthorizationRepository;
import com.zxjdev.smile.domain.common.base.UseCase;

import javax.inject.Inject;

import io.reactivex.Observable;

public class Login extends UseCase<Login.RequestParams, Void> {

  private AuthorizationRepository authorizationRepository;

  @Inject
  public Login(AuthorizationRepository authorizationRepository) {
    this.authorizationRepository = authorizationRepository;
  }

  @Override
  protected Observable<Void> buildUseCaseObservable(RequestParams params) {
    return authorizationRepository.login(params.getUsername(), params.getPassword());
  }

  public static class RequestParams implements UseCase.RequestParams {

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
