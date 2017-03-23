package com.zxjdev.smile.domain.user.usecase;

import com.zxjdev.smile.domain.base.SchedulerFactory;
import com.zxjdev.smile.domain.base.UseCase;
import com.zxjdev.smile.domain.user.UserRepository;

import rx.Observable;

public class Register extends UseCase<Register.RequestParams, Void> {

  private UserRepository userRepository;

  public Register(SchedulerFactory schedulerFactory, UserRepository userRepository) {
    super(schedulerFactory);
    this.userRepository = userRepository;
  }

  @Override
  protected Observable<Void> buildUseCaseObservable(RequestParams params) {
    return this.userRepository.register(params.getUsername(), params.getPassword());
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
