package com.zxjdev.smile.presentation.user.authorization.login;

import com.zxjdev.smile.domain.user.LoginUseCase;
import com.zxjdev.smile.domain.user.User;
import com.zxjdev.smile.presentation.application.DefaultSubscriber;

import javax.inject.Inject;

import timber.log.Timber;

public class LoginPresenter implements LoginContract.Presenter {

    @Inject LoginContract.View view;
    @Inject LoginUseCase loginUseCase;

    @Inject
    public LoginPresenter() {

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
