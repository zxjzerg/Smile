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

    @Inject MainContract.View view;
    @Inject GetCurrentUser getCurrentUser;
    @Inject UserModelMapper userModelMapper;
    @Inject UploadAvatar uploadAvatar;
    @Inject ErrorMessagePrinter errorMessagePrinter;

    @Inject
    public MainPresenter() {

    }

    public void setView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void onCreate() {
        getCurrentUser.execute(new DefaultSubscriber<User>(errorMessagePrinter) {
            @Override
            public void onNext(User data) {
                UserModel userModel = userModelMapper.transform(data);
                view.displayUser(userModel);
            }
        });
    }

    @Override
    public void onDestroy() {
        getCurrentUser.unsubscribe();
        uploadAvatar.unsubscribe();
    }

    @Override
    public void handleChangeAvatar(String picturePath) {
        UploadAvatar.RequestParams params = new UploadAvatar.RequestParams();
        params.setLocalPath(picturePath);
        uploadAvatar.execute(params, new DefaultSubscriber<String>(errorMessagePrinter) {
            @Override
            public void onNext(String data) {
                view.changeUserAvatar(data);
            }
        });
    }
}
