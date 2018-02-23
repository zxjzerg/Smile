package com.zxjdev.smile.presentation.user.settings;

import com.zxjdev.smile.presentation.common.base.BasePresenter;
import com.zxjdev.smile.presentation.common.base.BaseView;

public interface SettingsContract {

  interface View extends BaseView {

    void onLogoutSuccess();
  }

  interface Presenter extends BasePresenter<View> {

    void handleLogout();
  }
}
