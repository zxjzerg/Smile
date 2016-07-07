package com.zxjdev.smile.presentation.presenter.authorization;

import com.zxjdev.smile.domain.bo.User;
import com.zxjdev.smile.domain.interactor.LoginUseCase;
import com.zxjdev.smile.presentation.presenter.DefaultSubscriber;
import com.zxjdev.smile.presentation.view.i.authorization.ILoginView;

import javax.inject.Inject;

import timber.log.Timber;

public class LoginPresenter {

    private LoginUseCase mLoginUseCase;
    private ILoginView mView;

    @Inject
    public LoginPresenter(LoginUseCase loginUseCase) {
        this.mLoginUseCase = loginUseCase;
    }

    public void setView(ILoginView view) {
        this.mView = view;
    }

    public void handleLoginClick(String username, String password) {
        mLoginUseCase.setInput(username, password);
        mLoginUseCase.execute(new DefaultSubscriber<User>(mView.context()) {
            @Override
            public void onNext(User user) {
                Timber.d("login success. user: " + user.getUsername());
                mView.navigateToMain();
            }
        });
    }

    public void destroy() {
        mLoginUseCase.unSubscribe();
    }
}
