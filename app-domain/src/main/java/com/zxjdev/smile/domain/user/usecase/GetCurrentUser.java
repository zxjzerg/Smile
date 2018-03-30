package com.zxjdev.smile.domain.user.usecase;

import com.zxjdev.smile.domain.common.base.DataUseCase;
import com.zxjdev.smile.domain.common.base.UseCaseRequestParams;
import com.zxjdev.smile.domain.user.User;
import com.zxjdev.smile.domain.user.UserRepository;

import io.reactivex.Observable;

public class GetCurrentUser extends DataUseCase<GetCurrentUser.RequestParams, User> {

  private UserRepository userRepository;

  public GetCurrentUser(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  protected Observable<User> buildUseCaseObservable(RequestParams params) {
    return userRepository.getCurrentUser();
  }

  public static final class RequestParams implements UseCaseRequestParams {

  }
}
