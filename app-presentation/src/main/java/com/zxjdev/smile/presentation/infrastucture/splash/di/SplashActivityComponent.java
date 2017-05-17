package com.zxjdev.smile.presentation.infrastucture.splash.di;

import com.zxjdev.smile.presentation.common.base.activity.ActivityModule;
import com.zxjdev.smile.presentation.common.di.scope.ActivityScope;
import com.zxjdev.smile.presentation.infrastucture.splash.SplashActivity;

import dagger.Subcomponent;

@Subcomponent(modules = {ActivityModule.class, SplashActivityModule.class})
@ActivityScope
public interface SplashActivityComponent {

  void inject(SplashActivity activity);
}
