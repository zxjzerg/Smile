package com.zxjdev.smile.presentation.user.authorization.register;

public interface RegisterContract {

  interface View {

    void navigateToMain();
  }

  interface Presenter {

    void handleRegister(String username, String password);
  }
}
