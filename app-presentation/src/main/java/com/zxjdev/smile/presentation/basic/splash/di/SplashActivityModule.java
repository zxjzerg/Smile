package com.zxjdev.smile.presentation.basic.splash.di;

import com.zxjdev.smile.presentation.basic.splash.SplashContract;
import com.zxjdev.smile.presentation.basic.splash.SplashPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class SplashActivityModule {

  private SplashContract.View view;

  public SplashActivityModule(SplashContract.View view) {
    this.view = view;
  }

  @Provides
  SplashContract.View provideView() {
    return view;
  }

  @Provides
  SplashContract.Presenter providePresenter(SplashPresenter presenter) {
    return presenter;
  }
}
