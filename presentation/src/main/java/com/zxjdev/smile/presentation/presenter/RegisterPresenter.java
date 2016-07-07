package com.zxjdev.smile.presentation.presenter;

import com.zxjdev.smile.domain.interactor.RegisterUseCase;
import com.zxjdev.smile.presentation.view.i.IRegisterView;

import javax.inject.Inject;

public class RegisterPresenter {

    private IRegisterView mView;
    private RegisterUseCase mRegisterUseCase;

    @Inject
    public RegisterPresenter(RegisterUseCase registerUseCase) {
        mRegisterUseCase = registerUseCase;
    }

    public void setView(IRegisterView view) {
        mView = view;
    }

    public void handleRegister(String username, String password) {
        mRegisterUseCase.setInput(username, password);
        mRegisterUseCase.execute(new DefaultSubscriber(mView.context()) {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
            }
        });
    }
}
