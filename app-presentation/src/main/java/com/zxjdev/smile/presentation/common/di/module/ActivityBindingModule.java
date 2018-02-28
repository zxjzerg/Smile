package com.zxjdev.smile.presentation.common.di.module;

import com.zxjdev.smile.presentation.authorization.login.LoginActivity;
import com.zxjdev.smile.presentation.authorization.register.RegisterActivity;
import com.zxjdev.smile.presentation.common.base.activity.ActivityModule;
import com.zxjdev.smile.presentation.common.di.scope.ActivityScope;
import com.zxjdev.smile.presentation.infrastucture.main.MainActivity;
import com.zxjdev.smile.presentation.infrastucture.main.MainActivityModule;
import com.zxjdev.smile.presentation.infrastucture.splash.SplashActivity;
import com.zxjdev.smile.presentation.moment.create.NewMomentActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

  @ActivityScope
  @ContributesAndroidInjector(modules = ActivityModule.class)
  abstract SplashActivity splashActivity();

  @ActivityScope
  @ContributesAndroidInjector(modules = ActivityModule.class)
  abstract LoginActivity loginActivity();

  @ActivityScope
  @ContributesAndroidInjector(modules = ActivityModule.class)
  abstract RegisterActivity registerActivity();

  @ActivityScope
  @ContributesAndroidInjector(modules = MainActivityModule.class)
  abstract MainActivity mainActivity();

  @ActivityScope
  @ContributesAndroidInjector(modules = ActivityModule.class)
  abstract NewMomentActivity newMomentActivity();
}
