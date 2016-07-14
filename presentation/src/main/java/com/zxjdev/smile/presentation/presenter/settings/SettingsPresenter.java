package com.zxjdev.smile.presentation.presenter.settings;

import com.zxjdev.smile.domain.interactor.LogoutUseCase;
import com.zxjdev.smile.presentation.presenter.DefaultSubscriber;
import com.zxjdev.smile.presentation.view.i.settings.ISettingsView;

import javax.inject.Inject;

public class SettingsPresenter {

    private ISettingsView mView;
    private LogoutUseCase mLogoutUseCase;

    @Inject
    public SettingsPresenter(LogoutUseCase logoutUseCase) {
        mLogoutUseCase = logoutUseCase;
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
