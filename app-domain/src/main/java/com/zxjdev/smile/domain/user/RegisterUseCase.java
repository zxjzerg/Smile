package com.zxjdev.smile.domain.user;

import com.zxjdev.smile.domain.base.UseCase;
import com.zxjdev.smile.domain.base.UseCaseConfig;

import rx.Observable;

public class RegisterUseCase extends UseCase<RegisterUseCase.RequestParams, Void> {

    private UserRepository userRepository;

    public RegisterUseCase(UseCaseConfig useCaseConfig, UserRepository userRepository) {
        super(useCaseConfig);
        this.userRepository = userRepository;
    }

    @Override
    protected Observable<Void> buildUseCaseObservable(RequestParams params) {
        return this.userRepository.register(params.getUsername(), params.getPassword());
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
