package com.zxjdev.smile.presentation.user.settings;

import com.zxjdev.smile.domain.user.LogoutUseCase;
import com.zxjdev.smile.presentation.application.DefaultSubscriber;

import javax.inject.Inject;

public class SettingsPresenter implements SettingsContract.Presenter {

    @Inject SettingsContract.View view;
    @Inject LogoutUseCase logoutUseCase;

    @Inject
    public SettingsPresenter() {

    }

    @Override
    public void handleLogout() {
        logoutUseCase.execute(new DefaultSubscriber<Void>(view.context()) {
            @Override
            public void onCompleted() {
                super.onCompleted();
                view.navigateToSplash();
            }
        });
    }

    @Override
    public void destroy() {
        logoutUseCase.unSubscribe();
    }
}
