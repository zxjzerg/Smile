package com.zxjdev.smile.presentation.authorization.login;

import com.zxjdev.smile.domain.authorization.usecase.Login;
import com.zxjdev.smile.presentation.common.DefaultSubscriber;
import com.zxjdev.smile.presentation.common.util.ui.ErrorMessagePrinter;

import javax.inject.Inject;

import timber.log.Timber;

public class LoginPresenter implements LoginContract.Presenter {

  @Inject LoginContract.View view;
  @Inject Login login;
  @Inject ErrorMessagePrinter errorMessagePrinter;

  @Inject
  public LoginPresenter() {

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
  public void destroy() {
    login.unsubscribe();
  }
}
