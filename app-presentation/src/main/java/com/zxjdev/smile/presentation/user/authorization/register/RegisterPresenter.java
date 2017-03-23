package com.zxjdev.smile.presentation.user.authorization.register;

import com.zxjdev.smile.domain.user.usecase.Register;
import com.zxjdev.smile.presentation.application.DefaultSubscriber;
import com.zxjdev.smile.presentation.application.util.ui.ErrorMessagePrinter;

import javax.inject.Inject;

public class RegisterPresenter implements RegisterContract.Presenter {

    @Inject RegisterContract.View view;
    @Inject Register register;
    @Inject ErrorMessagePrinter errorMessagePrinter;

    @Inject
    public RegisterPresenter() {

    }

    @Override
    public void handleRegister(String username, String password) {
        register.execute(new Register.RequestParams(username, password),
            new DefaultSubscriber<Void>(errorMessagePrinter) {
                @Override
                public void onCompleted() {
                    view.navigateToMain();
                }
            });
    }
}
