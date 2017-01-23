package com.zxjdev.smile.presentation.user.settings;

import com.zxjdev.smile.domain.user.LogoutUseCase;
import com.zxjdev.smile.presentation.application.DefaultSubscriber;

import javax.inject.Inject;

public class SettingsPresenter {

    private SettingsView view;
    @Inject LogoutUseCase logoutUseCase;

    @Inject
    public SettingsPresenter() {

    }

    public void setView(SettingsView view) {
        this.view = view;
    }

    public void handleLogout() {
        logoutUseCase.execute(new DefaultSubscriber<Void>(view.context()) {
            @Override
            public void onCompleted() {
                super.onCompleted();
                view.navigateToSplash();
            }
        });
    }

    public void destroy() {
        logoutUseCase.unSubscribe();
    }
}
