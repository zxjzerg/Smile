package com.zxjdev.smile.presentation.infrastucture.main;

import com.zxjdev.smile.presentation.common.base.BasePresenter;
import com.zxjdev.smile.presentation.common.base.BaseView;
import com.zxjdev.smile.presentation.user.UserModel;

public interface MainContract {

  interface View extends BaseView {

    void displayUser(UserModel user);
  }

  interface Presenter extends BasePresenter<View> {

    void handleChangeAvatar(String picturePath);
  }
}
