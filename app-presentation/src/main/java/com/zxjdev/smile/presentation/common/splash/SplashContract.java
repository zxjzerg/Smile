package com.zxjdev.smile.presentation.common.splash;

public interface SplashContract {

  interface View {

    void navigateToMain();

    void showButtons();
  }

  interface Presenter {

    void handleAutoLogin();

    void destroy();
  }
}
