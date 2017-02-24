package com.zxjdev.smile.domain.user;

import com.zxjdev.smile.domain.base.UseCase;
import com.zxjdev.smile.domain.base.UseCaseConfig;

import rx.Observable;

public class UploadAvatarUseCase extends UseCase<UploadAvatarUseCase.RequestParams, String> {

    private UserRepository userRepository;

    public UploadAvatarUseCase(UseCaseConfig useCaseConfig, UserRepository userRepository) {
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
