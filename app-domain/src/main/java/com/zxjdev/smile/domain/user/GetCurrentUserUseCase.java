package com.zxjdev.smile.domain.user;

import com.zxjdev.smile.domain.base.UseCase;
import com.zxjdev.smile.domain.base.UseCaseConfig;

import rx.Observable;

public class GetCurrentUserUseCase extends UseCase<GetCurrentUserUseCase.RequestParams, User> {

    private UserRepository userRepository;

    public GetCurrentUserUseCase(UseCaseConfig useCaseConfig, UserRepository userRepository) {
        super(useCaseConfig);
        this.userRepository = userRepository;
    }

    @Override
    protected Observable<User> buildUseCaseObservable(RequestParams params) {
        return userRepository.getCurrentUser();
    }

    public static final class RequestParams implements UseCase.RequestParams {

    }
}
