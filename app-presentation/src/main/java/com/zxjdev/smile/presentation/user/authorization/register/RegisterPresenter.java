package com.zxjdev.smile.presentation.user.authorization.register;

import com.zxjdev.smile.domain.user.RegisterUseCase;
import com.zxjdev.smile.presentation.application.DefaultSubscriber;

import javax.inject.Inject;

public class RegisterPresenter {

    private RegisterView view;
    @Inject RegisterUseCase registerUseCase;

    @Inject
    public RegisterPresenter() {

    }

    public void setView(RegisterView view) {
        this.view = view;
    }

    public void handleRegister(String username, String password) {
        registerUseCase.setInput(username, password);
        registerUseCase.execute(new DefaultSubscriber(view.context()) {
            @Override
            public void onCompleted() {
                view.navigateToMain();
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
            }
        });
    }
}
