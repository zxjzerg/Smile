package com.zxjdev.smile.presentation.common.di.component;

import android.app.Application;

import com.zxjdev.smile.presentation.authorization.login.di.LoginActivityComponent;
import com.zxjdev.smile.presentation.authorization.register.di.RegisterActivityComponent;
import com.zxjdev.smile.presentation.common.SmileApplication;
import com.zxjdev.smile.presentation.common.base.activity.ActivityModule;
import com.zxjdev.smile.presentation.common.di.module.ApplicationModule;
import com.zxjdev.smile.presentation.common.di.module.AuthorizationDomainModule;
import com.zxjdev.smile.presentation.common.di.module.MomentDomainModule;
import com.zxjdev.smile.presentation.common.di.module.UserDomainModule;
import com.zxjdev.smile.presentation.infrastucture.main.di.MainActivityComponent;
import com.zxjdev.smile.presentation.infrastucture.splash.di.SplashActivityComponent;
import com.zxjdev.smile.presentation.moment.create.di.NewMomentActivityComponent;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;

@Singleton
@Component(modules = {
  ApplicationModule.class, AuthorizationDomainModule.class, MomentDomainModule.class, UserDomainModule.class
})
public interface ApplicationComponent extends AndroidInjector<SmileApplication> {

  SplashActivityComponent getSplashActivityComponent(ActivityModule activityModule);

  LoginActivityComponent getLoginActivityComponent(ActivityModule activityModule);

  RegisterActivityComponent getRegisterActivityComponent(ActivityModule activityModule);

  NewMomentActivityComponent getNewMomentActivityComponent(ActivityModule activityModule);

  MainActivityComponent getMainActivityComponent(ActivityModule activityModule);

  @Component.Builder
  interface Builder {

    @BindsInstance
    ApplicationComponent.Builder application(Application application);

    ApplicationComponent build();
  }
}
