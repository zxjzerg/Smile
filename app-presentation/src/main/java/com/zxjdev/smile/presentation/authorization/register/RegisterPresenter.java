package com.zxjdev.smile.presentation.authorization.register;

import com.zxjdev.smile.domain.authorization.usecase.Register;
import com.zxjdev.smile.presentation.common.DefaultSubscriber;
import com.zxjdev.smile.presentation.common.util.ui.ErrorMessagePrinter;

import javax.inject.Inject;

public class RegisterPresenter implements RegisterContract.Presenter {

  @Inject RegisterContract.View view;
  @Inject Register register;
  @Inject ErrorMessagePrinter errorMessagePrinter;

  @Inject
  public RegisterPresenter() {

  }

  @Override
  public void handleRegister(String username, String password) {
    register.execute(new Register.RequestParams(username, password), new DefaultSubscriber<Void>(errorMessagePrinter) {
      @Override
      public void onComplete() {
        view.initUserComponent();
        view.navigateToMain();
      }
    });
  }
}
