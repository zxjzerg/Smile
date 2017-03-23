package com.zxjdev.smile.presentation.user.authorization.register.di;

import com.zxjdev.smile.presentation.user.authorization.register.RegisterContract;
import com.zxjdev.smile.presentation.user.authorization.register.RegisterPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class RegisterActivityModule {

  private RegisterContract.View view;

  public RegisterActivityModule(RegisterContract.View view) {
    this.view = view;
  }

  @Provides
  RegisterContract.View provideView() {
    return view;
  }

  @Provides
  RegisterContract.Presenter providePresenter(RegisterPresenter presenter) {
    return presenter;
  }
}
