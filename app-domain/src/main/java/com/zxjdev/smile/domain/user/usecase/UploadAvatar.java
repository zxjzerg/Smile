package com.zxjdev.smile.domain.user.usecase;

import com.zxjdev.smile.domain.base.UseCase;
import com.zxjdev.smile.domain.base.UseCaseConfig;
import com.zxjdev.smile.domain.user.UserRepository;

import rx.Observable;

public class UploadAvatar extends UseCase<UploadAvatar.RequestParams, String> {

    private UserRepository userRepository;

    public UploadAvatar(UseCaseConfig useCaseConfig, UserRepository userRepository) {
        super(useCaseConfig);
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
