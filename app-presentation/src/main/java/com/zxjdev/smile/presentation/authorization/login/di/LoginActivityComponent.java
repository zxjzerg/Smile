package com.zxjdev.smile.presentation.authorization.login.di;

import com.zxjdev.smile.presentation.communal.base.activity.ActivityModule;
import com.zxjdev.smile.presentation.communal.di.scope.ActivityScope;
import com.zxjdev.smile.presentation.authorization.login.LoginActivity;

import dagger.Subcomponent;

@Subcomponent(modules = {ActivityModule.class, LoginActivityModule.class})
@ActivityScope
public interface LoginActivityComponent {

  void inject(LoginActivity activity);
}
