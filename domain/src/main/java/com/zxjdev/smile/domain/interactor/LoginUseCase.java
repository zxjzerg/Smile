package com.zxjdev.smile.domain.interactor;

import com.zxjdev.smile.domain.repository.UserRepository;

import javax.inject.Inject;

import rx.Observable;
import rx.Scheduler;

public class LoginUseCase extends UseCase {

    private UserRepository userRepository;

    private String username;
    private String password;

    @Inject
    public LoginUseCase(UserRepository userRepository, Scheduler postExecutionThread) {
        super(postExecutionThread);
        this.userRepository = userRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return this.userRepository.login(this.username, this.password);
    }

    public void setInput(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
