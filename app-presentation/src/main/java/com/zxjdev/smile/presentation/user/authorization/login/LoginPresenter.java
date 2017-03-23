package com.zxjdev.smile.presentation.user.authorization.login;

import com.zxjdev.smile.domain.user.User;
import com.zxjdev.smile.domain.user.usecase.Login;
import com.zxjdev.smile.presentation.application.DefaultSubscriber;
import com.zxjdev.smile.presentation.application.util.ui.ErrorMessagePrinter;

import javax.inject.Inject;

import timber.log.Timber;

public class LoginPresenter implements LoginContract.Presenter {

    @Inject LoginContract.View view;
    @Inject Login login;
    @Inject ErrorMessagePrinter errorMessagePrinter;

    @Inject
    public LoginPresenter() {

    }

    @Override
    public void handleLogin(String username, String password) {
        login.execute(new Login.RequestParams(username, password),
            new DefaultSubscriber<User>(errorMessagePrinter) {
                @Override
                public void onNext(User user) {
                    Timber.d("login success. user: %s", user.getUsername());
                    view.navigateToMain();
                }
            });
    }

    @Override
    public void destroy() {
        login.unSubscribe();
    }
}
