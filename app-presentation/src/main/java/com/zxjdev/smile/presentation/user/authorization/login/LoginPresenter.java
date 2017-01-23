package com.zxjdev.smile.presentation.user.authorization.login;

import com.zxjdev.smile.domain.user.User;
import com.zxjdev.smile.domain.user.LoginUseCase;
import com.zxjdev.smile.presentation.application.DefaultSubscriber;

import javax.inject.Inject;

import timber.log.Timber;

public class LoginPresenter {

    @Inject LoginUseCase loginUseCase;
    private LoginView view;

    @Inject
    public LoginPresenter() {

    }

    public void setView(LoginView view) {
        this.view = view;
    }

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

    public void destroy() {
        loginUseCase.unSubscribe();
    }
}
