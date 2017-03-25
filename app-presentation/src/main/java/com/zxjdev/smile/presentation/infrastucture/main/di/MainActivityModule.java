package com.zxjdev.smile.presentation.infrastucture.main.di;

import com.zxjdev.smile.presentation.infrastucture.main.MainContract;
import com.zxjdev.smile.presentation.infrastucture.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

  private MainContract.View view;

  public MainActivityModule(MainContract.View view) {
    this.view = view;
  }

  @Provides
  MainContract.View provideView() {
    return view;
  }

  @Provides
  MainContract.Presenter providePresenter(MainPresenter presenter) {
    return presenter;
  }
}