package com.zxjdev.smile.presentation.common.splash;

import android.content.Context;

public interface SplashContract {

    interface View {

        Context context();

        void navigateToMain();

        void showButtons();
    }

    interface Presenter {

        void handleAutoLogin();

        void destroy();
    }
}
