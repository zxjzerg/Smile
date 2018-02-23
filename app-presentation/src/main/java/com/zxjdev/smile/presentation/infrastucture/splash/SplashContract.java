package com.zxjdev.smile.presentation.infrastucture.splash;

import com.zxjdev.smile.presentation.common.base.BasePresenter;
import com.zxjdev.smile.presentation.common.base.BaseView;

public interface SplashContract {

  interface View extends BaseView {

    void navigateToMain();

    void showButtons();
  }

  interface Presenter extends BasePresenter<View> {

    void handleAutoLogin();
  }
}
