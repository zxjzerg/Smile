package com.zxjdev.smile.domain.interactor;

import com.zxjdev.smile.domain.repository.UserRepository;

import javax.inject.Inject;

import rx.Observable;
import rx.Scheduler;

public class AutoLoginUseCase extends UseCase {
    private UserRepository userRepository;

    @Inject
    public AutoLoginUseCase(UserRepository userRepository, Scheduler postExecutionThread) {
        super(postExecutionThread);
        this.userRepository = userRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return this.userRepository.checkHasAuthorized();
    }
}
