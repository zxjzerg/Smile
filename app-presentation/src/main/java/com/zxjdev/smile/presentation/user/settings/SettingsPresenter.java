package com.zxjdev.smile.presentation.user.settings;

import com.zxjdev.smile.domain.user.LogoutUseCase;
import com.zxjdev.smile.presentation.application.DefaultSubscriber;

public class SettingsPresenter implements SettingsContract.Presenter {

    private SettingsContract.View view;

    private LogoutUseCase logoutUseCase;

    public SettingsPresenter(SettingsContract.View view, LogoutUseCase logoutUseCase) {
        this.view = view;
        this.logoutUseCase = logoutUseCase;
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
