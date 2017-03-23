package com.zxjdev.smile.presentation.application.base.activity;

import com.zxjdev.smile.presentation.application.di.scope.ActivityScope;
import com.zxjdev.smile.presentation.common.main.di.MainActivityComponent;
import com.zxjdev.smile.presentation.common.main.di.MainActivityModule;
import com.zxjdev.smile.presentation.common.splash.di.SplashActivityComponent;
import com.zxjdev.smile.presentation.common.splash.di.SplashActivityModule;
import com.zxjdev.smile.presentation.moment.create.di.NewMomentActivityComponent;
import com.zxjdev.smile.presentation.moment.create.di.NewMomentActivityModule;
import com.zxjdev.smile.presentation.user.authorization.login.di.LoginActivityComponent;
import com.zxjdev.smile.presentation.user.authorization.login.di.LoginActivityModule;
import com.zxjdev.smile.presentation.user.authorization.register.di.RegisterActivityComponent;
import com.zxjdev.smile.presentation.user.authorization.register.di.RegisterActivityModule;

import dagger.Subcomponent;

@Subcomponent(modules = {ActivityModule.class})
@ActivityScope
public interface ActivityComponent {

  NewMomentActivityComponent getNewMomentActivityComponent(NewMomentActivityModule newMomentActivityModule);

  LoginActivityComponent getLoginActivityComponent(LoginActivityModule loginActivityModule);

  RegisterActivityComponent getRegisterActivityComponent(RegisterActivityModule registerActivityModule);

  SplashActivityComponent getSplashActivityComponent(SplashActivityModule splashActivityModule);

  MainActivityComponent getMainActivityComponent(MainActivityModule mainActivityModule);
}
