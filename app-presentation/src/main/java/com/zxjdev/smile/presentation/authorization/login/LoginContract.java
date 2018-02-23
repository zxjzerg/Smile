package com.zxjdev.smile.presentation.authorization.login;

import com.zxjdev.smile.presentation.common.base.BasePresenter;
import com.zxjdev.smile.presentation.common.base.BaseView;

public interface LoginContract {

  interface View extends BaseView {

    void navigateToMain();

    void initUserComponent();
  }

  interface Presenter extends BasePresenter<View> {

    void handleLogin(String username, String password);
  }
}
