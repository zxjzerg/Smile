package com.zxjdev.smile.presentation.infrastucture.splash.di;

import com.zxjdev.smile.presentation.infrastucture.splash.SplashContract;
import com.zxjdev.smile.presentation.infrastucture.splash.SplashPresenter;

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
