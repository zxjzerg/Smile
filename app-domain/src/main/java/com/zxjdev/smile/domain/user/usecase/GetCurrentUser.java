package com.zxjdev.smile.domain.user.usecase;

import com.zxjdev.smile.domain.communal.base.SchedulerFactory;
import com.zxjdev.smile.domain.communal.base.UseCase;
import com.zxjdev.smile.domain.user.User;
import com.zxjdev.smile.domain.user.UserRepository;

import rx.Observable;

public class GetCurrentUser extends UseCase<GetCurrentUser.RequestParams, User> {

  private UserRepository userRepository;

  public GetCurrentUser(SchedulerFactory schedulerFactory, UserRepository userRepository) {
    super(schedulerFactory);
    this.userRepository = userRepository;
  }

  @Override
  protected Observable<User> buildUseCaseObservable(RequestParams params) {
    return userRepository.getCurrentUser();
  }

  public static final class RequestParams implements UseCase.RequestParams {

  }
}
