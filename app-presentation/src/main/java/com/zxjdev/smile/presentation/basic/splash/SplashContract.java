package com.zxjdev.smile.presentation.basic.splash;

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
