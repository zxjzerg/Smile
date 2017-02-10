package com.zxjdev.smile.presentation.common.main;

import com.zxjdev.smile.domain.user.GetCurrentUserUseCase;
import com.zxjdev.smile.domain.user.User;
import com.zxjdev.smile.presentation.application.DefaultSubscriber;
import com.zxjdev.smile.presentation.user.UserModel;
import com.zxjdev.smile.presentation.user.UserModelMapper;

import javax.inject.Inject;

public class MainPresenter implements MainContract.Presenter {

    @Inject MainContract.View view;
    @Inject GetCurrentUserUseCase getCurrentUserUseCase;
    @Inject UserModelMapper userModelMapper;

    @Inject
    public MainPresenter() {

    }

    public void setView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void onCreate() {
        getCurrentUserUseCase.execute(new DefaultSubscriber<User>(view.context()) {
            @Override
            public void onNext(User data) {
                UserModel userModel = userModelMapper.transform(data);
                view.displayUser(userModel);
            }
        });
    }
}
