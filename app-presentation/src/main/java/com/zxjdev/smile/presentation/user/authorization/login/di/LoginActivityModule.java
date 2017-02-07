package com.zxjdev.smile.presentation.user.authorization.login.di;

import com.zxjdev.smile.domain.user.LoginUseCase;
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
    LoginContract.Presenter providePresenter(LoginUseCase loginUseCase) {
        return new LoginPresenter(view, loginUseCase);
    }
}
