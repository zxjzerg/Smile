package com.zxjdev.smile.presentation.authorization.register;

public interface RegisterContract {

  interface View {

    void navigateToMain();

    void initUserComponent();
  }

  interface Presenter {

    void handleRegister(String username, String password);
  }
}