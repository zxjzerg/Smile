package com.zxjdev.smile.domain.user.usecase;

import com.zxjdev.smile.domain.base.SchedulerFactory;
import com.zxjdev.smile.domain.base.UseCase;
import com.zxjdev.smile.domain.user.UserRepository;

import rx.Observable;

public class AutoLogin extends UseCase<AutoLogin.RequestParams, Boolean> {

  private UserRepository userRepository;

  public AutoLogin(SchedulerFactory schedulerFactory, UserRepository userRepository) {
    super(schedulerFactory);
    this.userRepository = userRepository;
  }

  @Override
  protected Observable<Boolean> buildUseCaseObservable(RequestParams params) {
    return this.userRepository.checkHasAuthorized();
  }

  public static class RequestParams implements UseCase.RequestParams {

  }
}