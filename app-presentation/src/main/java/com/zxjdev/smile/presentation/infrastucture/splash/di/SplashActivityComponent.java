package com.zxjdev.smile.presentation.infrastucture.splash.di;

import com.zxjdev.smile.presentation.communal.base.activity.ActivityModule;
import com.zxjdev.smile.presentation.communal.di.scope.ActivityScope;
import com.zxjdev.smile.presentation.infrastucture.splash.SplashActivity;

import dagger.Subcomponent;

@Subcomponent(modules = {ActivityModule.class, SplashActivityModule.class})
@ActivityScope
public interface SplashActivityComponent {

  void inject(SplashActivity activity);
}