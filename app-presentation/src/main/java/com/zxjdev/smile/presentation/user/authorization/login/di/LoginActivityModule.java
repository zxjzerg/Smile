package com.zxjdev.smile.presentation.user.authorization.login.di;

import com.zxjdev.smile.presentation.user.authorization.login.LoginContract;
import com.zxjdev.smile.presentation.user.authorization.login.LoginPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginActivityModule {

    private LoginContract.View view;

    public LoginActivityModule(LoginContract.View view) {
        this.view = view;
    }

    @Provides
    LoginContract.View provideView() {
        return view;
    }

    @Provides
    LoginContract.Presenter providePresenter(LoginPresenter presenter) {
        return presenter;
    }
}
