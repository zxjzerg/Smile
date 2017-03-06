package com.zxjdev.smile.presentation.user.authorization.login;

public interface LoginContract {

    interface View {

        void navigateToMain();
    }

    interface Presenter {

        void destroy();

        void handleLogin(String username, String password);
    }
}
