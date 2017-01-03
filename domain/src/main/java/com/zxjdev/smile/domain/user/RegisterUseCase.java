package com.zxjdev.smile.domain.user;

import com.zxjdev.smile.domain.base.UseCase;
import com.zxjdev.smile.domain.base.UseCaseConfig;

import rx.Observable;

public class RegisterUseCase extends UseCase<Void> {

    private UserRepository userRepository;

    private String username;
    private String password;

    public RegisterUseCase(UseCaseConfig useCaseConfig, UserRepository userRepository) {
        super(useCaseConfig);
        this.userRepository = userRepository;
    }

    @Override
    protected Observable<Void> buildUseCaseObservable() {
        return this.userRepository.register(this.username, this.password);
    }

    public void setInput(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
