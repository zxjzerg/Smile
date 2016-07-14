package com.zxjdev.smile.domain.interactor;

import com.zxjdev.smile.domain.repository.UserRepository;

import javax.inject.Inject;

import rx.Observable;
import rx.Scheduler;

public class LogoutUseCase extends UseCase {
    private UserRepository userRepository;

    @Inject
    public LogoutUseCase(UserRepository userRepository, Scheduler postExecutionThread) {
        super(postExecutionThread);
        this.userRepository = userRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return this.userRepository.logout();
    }
}
