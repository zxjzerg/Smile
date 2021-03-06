package com.zxjdev.smile.domain.user.usecase;

import com.zxjdev.smile.domain.common.base.DataUseCase;
import com.zxjdev.smile.domain.common.base.UseCaseRequestParams;
import com.zxjdev.smile.domain.user.UserRepository;

import io.reactivex.Observable;

public class UploadAvatar extends DataUseCase<UploadAvatar.RequestParams, String> {

  private UserRepository userRepository;

  public UploadAvatar(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  protected Observable<String> buildUseCaseObservable(RequestParams params) {
    return userRepository.uploadAvatar(params.getLocalPath());
  }

  public static class RequestParams implements UseCaseRequestParams {

    private String localPath;

    public String getLocalPath() {
      return localPath;
    }

    public void setLocalPath(String localPath) {
      this.localPath = localPath;
    }
  }
}
