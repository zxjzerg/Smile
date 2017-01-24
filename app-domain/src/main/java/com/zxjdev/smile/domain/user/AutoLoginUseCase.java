package com.zxjdev.smile.domain.user;

import com.zxjdev.smile.domain.base.UseCase;
import com.zxjdev.smile.domain.base.UseCaseConfig;

import rx.Observable;

public class AutoLoginUseCase extends UseCase<AutoLoginUseCase.RequestParams, Boolean> {

    private UserRepository userRepository;

    public AutoLoginUseCase(UseCaseConfig useCaseConfig, UserRepository userRepository) {
        super(useCaseConfig);
        this.userRepository = userRepository;
    }

    @Override
    protected Observable<Boolean> buildUseCaseObservable(RequestParams params) {
        return this.userRepository.checkHasAuthorized();
    }

    public static class RequestParams implements UseCase.RequestParams {

    }
}