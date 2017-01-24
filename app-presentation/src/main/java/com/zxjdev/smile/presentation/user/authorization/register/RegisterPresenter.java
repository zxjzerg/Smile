package com.zxjdev.smile.presentation.user.authorization.register;

import com.zxjdev.smile.domain.user.RegisterUseCase;
import com.zxjdev.smile.presentation.application.DefaultSubscriber;

public class RegisterPresenter implements RegisterContract.Presenter {

    private RegisterContract.View view;
    private RegisterUseCase registerUseCase;

    public RegisterPresenter(RegisterUseCase registerUseCase) {
        this.registerUseCase = registerUseCase;
    }

    @Override
    public void setView(RegisterContract.View view) {
        this.view = view;
    }

    @Override
    public void handleRegister(String username, String password) {
        registerUseCase.execute(new RegisterUseCase.RequestParams(username, password),
            new DefaultSubscriber<Void>(view.context()) {
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
