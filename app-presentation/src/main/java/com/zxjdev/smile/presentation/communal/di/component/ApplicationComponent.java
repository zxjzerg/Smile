package com.zxjdev.smile.presentation.communal.di.component;

import com.zxjdev.smile.presentation.authorization.login.di.LoginActivityComponent;
import com.zxjdev.smile.presentation.authorization.login.di.LoginActivityModule;
import com.zxjdev.smile.presentation.authorization.register.di.RegisterActivityComponent;
import com.zxjdev.smile.presentation.authorization.register.di.RegisterActivityModule;
import com.zxjdev.smile.presentation.infrastucture.splash.di.SplashActivityComponent;
import com.zxjdev.smile.presentation.infrastucture.splash.di.SplashActivityModule;
import com.zxjdev.smile.presentation.communal.base.activity.ActivityModule;
import com.zxjdev.smile.presentation.communal.di.module.ApplicationModule;
import com.zxjdev.smile.presentation.communal.di.module.AuthorizationDomainModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, AuthorizationDomainModule.class})
public interface ApplicationComponent {

  UserComponent getUserComponent();

  SplashActivityComponent getSplashActivityComponent(ActivityModule activityModule,
    SplashActivityModule splashActivityModule);

  LoginActivityComponent getLoginActivityComponent(ActivityModule activityModule,
    LoginActivityModule loginActivityModule);

  RegisterActivityComponent getRegisterActivityComponent(ActivityModule activityModule,
    RegisterActivityModule registerActivityModule);
}
