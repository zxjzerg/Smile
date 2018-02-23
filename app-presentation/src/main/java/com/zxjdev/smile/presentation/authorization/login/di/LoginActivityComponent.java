package com.zxjdev.smile.presentation.authorization.login.di;

import com.zxjdev.smile.presentation.common.base.activity.ActivityModule;
import com.zxjdev.smile.presentation.common.di.scope.ActivityScope;
import com.zxjdev.smile.presentation.authorization.login.LoginActivity;

import dagger.Subcomponent;

@Subcomponent(modules = {ActivityModule.class})
@ActivityScope
public interface LoginActivityComponent {

  void inject(LoginActivity activity);
}
