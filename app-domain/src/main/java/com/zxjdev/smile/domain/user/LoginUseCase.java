package com.zxjdev.smile.domain.user;

import com.zxjdev.smile.domain.base.UseCase;
import com.zxjdev.smile.domain.base.UseCaseConfig;

import javax.inject.Inject;

import rx.Observable;

public class LoginUseCase extends UseCase<LoginUseCase.RequestParams, User> {

    private UserRepository userRepository;

    @Inject
    public LoginUseCase(UseCaseConfig useCaseConfig, UserRepository userRepository) {
        super(useCaseConfig);
        this.userRepository = userRepository;
    }

    @Override
    protected Observable<User> buildUseCaseObservable(RequestParams params) {
        return this.userRepository.login(params.getUsername(), params.getPassword());
    }

    public static class RequestParams implements UseCase.RequestParams {

        private String username;
        private String password;

        public RequestParams(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }
}
