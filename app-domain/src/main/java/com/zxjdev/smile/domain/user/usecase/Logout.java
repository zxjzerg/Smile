package com.zxjdev.smile.domain.user.usecase;

import com.zxjdev.smile.domain.base.UseCase;
import com.zxjdev.smile.domain.base.UseCaseConfig;
import com.zxjdev.smile.domain.user.UserRepository;

import rx.Observable;

public class Logout extends UseCase<Logout.RequestParams, Void> {

    private UserRepository userRepository;

    public Logout(UseCaseConfig useCaseConfig, UserRepository userRepository) {
        super(useCaseConfig);
        this.userRepository = userRepository;
    }

    @Override
    protected Observable<Void> buildUseCaseObservable(RequestParams params) {
        return this.userRepository.logout();
    }

    public static class RequestParams implements UseCase.RequestParams {

    }
}
