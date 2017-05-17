package com.zxjdev.smile.presentation.user.settings;

import com.zxjdev.smile.domain.authorization.usecase.Logout;
import com.zxjdev.smile.presentation.common.DefaultSubscriber;
import com.zxjdev.smile.presentation.common.util.ui.ErrorMessagePrinter;

import javax.inject.Inject;

public class SettingsPresenter implements SettingsContract.Presenter {

  @Inject SettingsContract.View view;
  @Inject Logout logout;
  @Inject ErrorMessagePrinter errorMessagePrinter;

  @Inject
  public SettingsPresenter() {

  }

  @Override
  public void handleLogout() {
    logout.execute(new DefaultSubscriber<Void>(errorMessagePrinter) {
      @Override
      public void onCompleted() {
        view.onLogoutSuccess();
      }
    });
  }

  @Override
  public void onDestroy() {
    logout.unSubscribe();
  }
}
