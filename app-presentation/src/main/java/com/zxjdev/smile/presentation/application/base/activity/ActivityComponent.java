package com.zxjdev.smile.presentation.application.base.activity;

import com.zxjdev.smile.presentation.application.di.scope.ActivityScope;
import com.zxjdev.smile.presentation.common.splash.di.SplashActivityComponent;
import com.zxjdev.smile.presentation.common.splash.di.SplashActivityhModule;
import com.zxjdev.smile.presentation.moment.create.di.NewMomentActivityComponent;
import com.zxjdev.smile.presentation.moment.create.di.NewMomentActivityModule;
import com.zxjdev.smile.presentation.user.authorization.login.di.LoginActivityComponent;
import com.zxjdev.smile.presentation.user.authorization.login.di.LoginActivityModule;
import com.zxjdev.smile.presentation.user.authorization.register.di.RegisterActivityComponent;
import com.zxjdev.smile.presentation.user.authorization.register.di.RegisterActivityModule;

import dagger.Subcomponent;

@Subcomponent(
    modules = {
        ActivityModule.class
    })
@ActivityScope
public interface ActivityComponent {

    NewMomentActivityComponent getNewMomentComponent(NewMomentActivityModule newMomentActivityModule);

    LoginActivityComponent getLoginComponent(LoginActivityModule loginActivityModule);

    RegisterActivityComponent getRegisterComponent(RegisterActivityModule registerActivityModule);

    SplashActivityComponent getSplashComponent(SplashActivityhModule splashActivityhModule);
}
