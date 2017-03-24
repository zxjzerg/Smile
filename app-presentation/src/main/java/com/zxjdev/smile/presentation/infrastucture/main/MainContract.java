package com.zxjdev.smile.presentation.infrastucture.main;

import com.zxjdev.smile.presentation.user.UserModel;

public interface MainContract {

  interface View {

    void displayUser(UserModel user);

    void changeUserAvatar(String url);
  }

  interface Presenter {

    void onCreate();

    void onDestroy();

    void handleChangeAvatar(String picturePath);
  }
}
