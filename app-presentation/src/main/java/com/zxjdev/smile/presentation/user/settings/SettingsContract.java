package com.zxjdev.smile.presentation.user.settings;

import android.content.Context;

public interface SettingsContract {

    interface View {

        Context context();

        void navigateToSplash();
    }

    interface Presenter {

        void setView(View view);

        void handleLogout();

        void destroy();
    }
}
