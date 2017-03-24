package com.zxjdev.smile.presentation.authorization.register;

import com.zxjdev.smile.domain.authorization.usecase.Register;
import com.zxjdev.smile.presentation.communal.DefaultSubscriber;
import com.zxjdev.smile.presentation.communal.util.ui.ErrorMessagePrinter;

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
      public void onCompleted() {
        view.navigateToMain();
      }
    });
  }
}
