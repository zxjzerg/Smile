package com.zxjdev.smile.presentation.user.settings;

import com.zxjdev.smile.domain.user.usecase.Logout;
import com.zxjdev.smile.presentation.application.DefaultSubscriber;
import com.zxjdev.smile.presentation.application.util.ui.ErrorMessagePrinter;

import javax.inject.Inject;

public class SettingsPresenter implements SettingsContract.Presenter {

    @Inject SettingsContract.View view;
    @Inject Logout logout;
    @Inject ErrorMessagePrinter errorMessagePrinter;

    @Inject
    public SettingsPresenter() {

    }

    @Override
    public void handleLogout() {
        logout.execute(new DefaultSubscriber<Void>(errorMessagePrinter) {
            @Override
            public void onCompleted() {
                super.onCompleted();
                view.navigateToSplash();
            }
        });
    }

    @Override
    public void destroy() {
        logout.unSubscribe();
    }
}
