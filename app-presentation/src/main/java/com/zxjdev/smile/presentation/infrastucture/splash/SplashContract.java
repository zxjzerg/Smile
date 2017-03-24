package com.zxjdev.smile.presentation.infrastucture.splash;

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
