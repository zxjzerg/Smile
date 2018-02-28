package com.zxjdev.smile.domain.user.usecase;

import com.zxjdev.smile.domain.common.base.UseCase;
import com.zxjdev.smile.domain.user.User;
import com.zxjdev.smile.domain.user.UserRepository;

import io.reactivex.Observable;

public class GetUser extends UseCase<GetUser.RequestParams, User> {

  private UserRepository userRepository;

  public GetUser(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  protected Observable<User> buildUseCaseObservable(RequestParams params) {
    return null;
  }

  public static final class RequestParams implements UseCase.RequestParams {

  }
}
