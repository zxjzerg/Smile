package com.zxjdev.smile.presentation.user.authorization.register;

import android.content.Context;

public interface RegisterContract {

    interface View {

        Context context();

        void navigateToMain();
    }

    interface Presenter {

        void setView(View view);

        void handleRegister(String username, String password);
    }
}
