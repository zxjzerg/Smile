package com.zxjdev.smile.presentation.authorization.login;

import com.zxjdev.smile.domain.authorization.usecase.Login;
import com.zxjdev.smile.presentation.common.DefaultSubscriber;
import com.zxjdev.smile.presentation.common.util.ui.ErrorMessagePrinter;

import javax.inject.Inject;

import timber.log.Timber;

public class LoginPresenter implements LoginContract.Presenter {

  private LoginContract.View view;
  @Inject Login login;
  @Inject ErrorMessagePrinter errorMessagePrinter;

  @Inject
  LoginPresenter() {

  }

  @Override
  public void handleLogin(String username, String password) {
    login.execute(new Login.RequestParams(username, password), new DefaultSubscriber<Void>(errorMessagePrinter) {
      @Override
      public void onComplete() {
        view.initUserComponent();
        view.navigateToMain();
      }

      @Override
      public void onError() {
        Timber.d("Login failed.");
      }
    });
  }

  @Override
  public void takeView(LoginContract.View view) {
    this.view = view;
  }

  @Override
  public void dropView() {
    this.view = null;
    login.unsubscribe();
  }
}
