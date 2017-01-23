package com.zxjdev.smile.presentation.user.authorization.login;

import com.zxjdev.smile.domain.user.LoginUseCase;
import com.zxjdev.smile.domain.user.User;
import com.zxjdev.smile.presentation.application.DefaultSubscriber;

import timber.log.Timber;

public class LoginPresenter implements LoginContract.Presenter {

    private LoginUseCase loginUseCase;
    private LoginContract.View view;

    public LoginPresenter(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
    }

    @Override
    public void setView(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void handleLogin(String username, String password) {
        loginUseCase.setInput(username, password);
        loginUseCase.execute(new DefaultSubscriber<User>(view.context()) {
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
