package com.zxjdev.smile.domain.user;

import com.zxjdev.smile.domain.base.UseCase;
import com.zxjdev.smile.domain.base.UseCaseConfig;

import javax.inject.Inject;

import rx.Observable;

public class LoginUseCase extends UseCase<User> {

    private UserRepository userRepository;

    private String username;
    private String password;

    @Inject
    public LoginUseCase(UseCaseConfig useCaseConfig, UserRepository userRepository) {
        super(useCaseConfig);
        this.userRepository = userRepository;
    }

    @Override
    protected Observable<User> buildUseCaseObservable() {
        return this.userRepository.login(this.username, this.password);
    }

    public void setInput(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
