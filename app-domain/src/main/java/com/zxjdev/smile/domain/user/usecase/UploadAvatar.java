package com.zxjdev.smile.domain.user.usecase;

import com.zxjdev.smile.domain.common.SchedulerFactory;
import com.zxjdev.smile.domain.common.base.UseCase;
import com.zxjdev.smile.domain.user.UserRepository;

import rx.Observable;

public class UploadAvatar extends UseCase<UploadAvatar.RequestParams, String> {

  private UserRepository userRepository;

  public UploadAvatar(SchedulerFactory schedulerFactory, UserRepository userRepository) {
    super(schedulerFactory);
    this.userRepository = userRepository;
  }

  @Override
  protected Observable<String> buildUseCaseObservable(RequestParams params) {
    return userRepository.uploadAvatar(params.getLocalPath());
  }

  public static class RequestParams implements UseCase.RequestParams {

    private String localPath;

    public String getLocalPath() {
      return localPath;
    }

    public void setLocalPath(String localPath) {
      this.localPath = localPath;
    }
  }
}
