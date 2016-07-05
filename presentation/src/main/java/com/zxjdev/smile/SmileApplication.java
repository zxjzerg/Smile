package com.zxjdev.smile;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;

public class SmileApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        initLeanCloud();
    }

    private void initLeanCloud() {
        AVOSCloud.initialize(this, BuildConfig.LEANCOULD_APP_ID, BuildConfig.LEANCOULD_APP_KEY);
    }
}


