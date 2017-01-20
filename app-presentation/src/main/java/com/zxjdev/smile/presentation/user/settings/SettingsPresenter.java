package com.zxjdev.smile.presentation.user.settings;

import com.zxjdev.smile.domain.user.LogoutUseCase;
import com.zxjdev.smile.presentation.application.DefaultSubscriber;

import javax.inject.Inject;

public class SettingsPresenter {

    private ISettingsView mView;
    @Inject LogoutUseCase mLogoutUseCase;

    @Inject
    public SettingsPresenter() {

    }

    public void setView(ISettingsView view) {
        mView = view;
    }

    public void handleLogout() {
        mLogoutUseCase.execute(new DefaultSubscriber<Void>(mView.context()) {
            @Override
            public void onCompleted() {
                super.onCompleted();
                mView.navigateToSplash();
            }
        });
    }

    public void destroy() {
        mLogoutUseCase.unSubscribe();
    }
}
