package com.zxjdev.smile.presentation.authorization.register;

import com.zxjdev.smile.presentation.common.base.BasePresenter;
import com.zxjdev.smile.presentation.common.base.BaseView;

public interface RegisterContract {

  interface View extends BaseView {

    void navigateToMain();

    void initUserComponent();
  }

  interface Presenter extends BasePresenter<View> {

    void handleRegister(String username, String password);
  }
}