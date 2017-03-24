package com.zxjdev.smile.presentation.authorization.login;

public interface LoginContract {

  interface View {

    void navigateToMain();

    void initUserComponent();
  }

  interface Presenter {

    void destroy();

    void handleLogin(String username, String password);
  }
}
