package com.zxjdev.smile.presentation.user.settings;

public interface SettingsContract {

  interface View {

    void onLogoutSuccess();
  }

  interface Presenter {

    void handleLogout();

    void onDestroy();
  }
}
