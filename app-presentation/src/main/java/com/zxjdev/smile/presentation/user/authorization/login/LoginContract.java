package com.zxjdev.smile.presentation.user.authorization.login;

import android.content.Context;

public interface LoginContract {

    interface View {

        Context context();

        void navigateToMain();
    }

    interface Presenter {

        void setView(View view);

        void destroy();

        void handleLogin(String username, String password);
    }
}
