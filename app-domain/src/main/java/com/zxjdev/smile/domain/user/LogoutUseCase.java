package com.zxjdev.smile.domain.user;

import com.zxjdev.smile.domain.base.UseCase;
import com.zxjdev.smile.domain.base.UseCaseConfig;

import rx.Observable;

public class LogoutUseCase extends UseCase<Void> {

    private UserRepository userRepository;

    public LogoutUseCase(UseCaseConfig useCaseConfig, UserRepository userRepository) {
        super(useCaseConfig);
        this.userRepository = userRepository;
    }

    @Override
    protected Observable<Void> buildUseCaseObservable() {
        return this.userRepository.logout();
    }
}
