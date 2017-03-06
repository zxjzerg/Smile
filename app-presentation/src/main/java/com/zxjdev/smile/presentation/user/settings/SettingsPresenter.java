package com.zxjdev.smile.presentation.user.settings;

import com.zxjdev.smile.domain.user.LogoutUseCase;
import com.zxjdev.smile.presentation.application.DefaultSubscriber;
import com.zxjdev.smile.presentation.application.util.ui.ErrorMessagePrinter;

import javax.inject.Inject;

public class SettingsPresenter implements SettingsContract.Presenter {

    @Inject SettingsContract.View view;
    @Inject LogoutUseCase logoutUseCase;
    @Inject ErrorMessagePrinter errorMessagePrinter;

    @Inject
    public SettingsPresenter() {

    }

    @Override
    public void handleLogout() {
        logoutUseCase.execute(new DefaultSubscriber<Void>(errorMessagePrinter) {
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
