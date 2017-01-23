package com.zxjdev.smile.presentation.user.authorization.login.di;

import com.zxjdev.smile.presentation.user.authorization.login.LoginActivity;

import dagger.Subcomponent;

@Subcomponent(modules = {
    LoginActivityModule.class
})
public interface LoginActivityComponent {

    void inject(LoginActivity activity);
}
