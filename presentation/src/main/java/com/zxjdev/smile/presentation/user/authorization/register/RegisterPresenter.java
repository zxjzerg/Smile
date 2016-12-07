package com.zxjdev.smile.presentation.user.authorization.register;

import com.zxjdev.smile.domain.user.RegisterUseCase;
import com.zxjdev.smile.presentation.application.DefaultSubscriber;

import javax.inject.Inject;

public class RegisterPresenter {

    private IRegisterView mView;
    @Inject RegisterUseCase mRegisterUseCase;

    @Inject
    public RegisterPresenter() {

    }

    public void setView(IRegisterView view) {
        mView = view;
    }

    public void handleRegister(String username, String password) {
        mRegisterUseCase.setInput(username, password);
        mRegisterUseCase.execute(new DefaultSubscriber(mView.context()) {
            @Override
            public void onCompleted() {
                mView.navigateToMain();
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
            }
        });
    }
}
