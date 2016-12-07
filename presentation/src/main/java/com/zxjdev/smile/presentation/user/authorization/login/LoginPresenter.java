package com.zxjdev.smile.presentation.user.authorization.login;

import com.zxjdev.smile.domain.user.User;
import com.zxjdev.smile.domain.user.LoginUseCase;
import com.zxjdev.smile.presentation.application.DefaultSubscriber;

import javax.inject.Inject;

import timber.log.Timber;

public class LoginPresenter {

    @Inject LoginUseCase mLoginUseCase;
    private ILoginView mView;

    @Inject
    public LoginPresenter() {

    }

    public void setView(ILoginView view) {
        this.mView = view;
    }

    public void handleLogin(String username, String password) {
        mLoginUseCase.setInput(username, password);
        mLoginUseCase.execute(new DefaultSubscriber<User>(mView.context()) {
            @Override
            public void onNext(User user) {
                Timber.d("login success. user: %s", user.getUsername());
                mView.navigateToMain();
            }
        });
    }

    public void destroy() {
        mLoginUseCase.unSubscribe();
    }
}
