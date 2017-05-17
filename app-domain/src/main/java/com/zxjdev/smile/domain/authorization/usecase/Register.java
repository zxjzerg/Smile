package com.zxjdev.smile.domain.authorization.usecase;

import com.zxjdev.smile.domain.authorization.AuthorizationRepository;
import com.zxjdev.smile.domain.common.SchedulerFactory;
import com.zxjdev.smile.domain.common.base.UseCase;

import rx.Observable;

public class Register extends UseCase<Register.RequestParams, Void> {

  private AuthorizationRepository authorizationRepository;

  public Register(SchedulerFactory schedulerFactory, AuthorizationRepository authorizationRepository) {
    super(schedulerFactory);
    this.authorizationRepository = authorizationRepository;
  }

  @Override
  protected Observable<Void> buildUseCaseObservable(RequestParams params) {
    return authorizationRepository.register(params.getUsername(), params.getPassword());
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
