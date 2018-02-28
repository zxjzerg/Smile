package com.zxjdev.smile.presentation.infrastucture.main;

import com.zxjdev.smile.domain.user.User;
import com.zxjdev.smile.domain.user.usecase.GetCurrentUser;
import com.zxjdev.smile.domain.user.usecase.UploadAvatar;
import com.zxjdev.smile.presentation.common.DefaultSubscriber;
import com.zxjdev.smile.presentation.common.util.ui.ErrorMessagePrinter;
import com.zxjdev.smile.presentation.user.UserModel;
import com.zxjdev.smile.presentation.user.UserModelMapper;

import javax.inject.Inject;

public class MainPresenter implements MainContract.Presenter {

  private MainContract.View view;
  @Inject GetCurrentUser getCurrentUser;
  @Inject UserModelMapper userModelMapper;
  @Inject UploadAvatar uploadAvatar;
  @Inject ErrorMessagePrinter errorMessagePrinter;

  private UserModel currentUser;

  @Inject
  MainPresenter() {

  }

  @Override
  public void handleChangeAvatar(String picturePath) {
    UploadAvatar.RequestParams params = new UploadAvatar.RequestParams();
    params.setLocalPath(picturePath);
    uploadAvatar.execute(params, new DefaultSubscriber<String>(errorMessagePrinter) {
      @Override
      public void onNext(String data) {
        if (currentUser != null) {
          currentUser.setAvatar(data);
          if (view != null) view.displayUser(currentUser);
        }
      }
    });
  }

  @Override
  public void takeView(MainContract.View view) {
    this.view = view;
    loadCurrentUser();
  }

  @Override
  public void dropView() {
    this.view = null;
    getCurrentUser.unsubscribe();
    uploadAvatar.unsubscribe();
  }

  private void loadCurrentUser() {
    getCurrentUser.execute(new DefaultSubscriber<User>(errorMessagePrinter) {
      @Override
      public void onNext(User data) {
        currentUser = userModelMapper.transform(data);
        if (view != null) view.displayUser(currentUser);
      }
    });
  }
}
