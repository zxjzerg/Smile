package com.zxjdev.smile.presentation.common.main;

import android.content.Context;

import com.zxjdev.smile.presentation.user.UserModel;

public interface MainContract {

    interface View {

        Context context();

        void displayUser(UserModel user);
    }

    interface Presenter {

        void onCreate();
    }
}
