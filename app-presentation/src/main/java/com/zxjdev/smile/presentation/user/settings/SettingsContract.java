package com.zxjdev.smile.presentation.user.settings;

public interface SettingsContract {

    interface View {

        void navigateToSplash();
    }

    interface Presenter {

        void handleLogout();

        void destroy();
    }
}
