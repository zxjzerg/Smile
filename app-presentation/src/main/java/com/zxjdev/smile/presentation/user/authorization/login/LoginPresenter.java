package com.zxjdev.smile.presentation.user.authorization.login;

import com.zxjdev.smile.domain.user.LoginUseCase;
import com.zxjdev.smile.domain.user.User;
import com.zxjdev.smile.presentation.application.DefaultSubscriber;

import timber.log.Timber;

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View view;
    private LoginUseCase loginUseCase;

    public LoginPresenter(LoginContract.View view, LoginUseCase loginUseCase) {
        this.view = view;
        this.loginUseCase = loginUseCase;
    }

    @Override
    public void handleLogin(String username, String password) {
        loginUseCase.execute(new LoginUseCase.RequestParams(username, password),
            new DefaultSubscriber<User>(view.context()) {
                @Override
                public void onNext(User user) {
                    Timber.d("login success. user: %s", user.getUsername());
                    view.navigateToMain();
                }
            });
    }

    @Override
    public void destroy() {
        loginUseCase.unSubscribe();
    }
}
