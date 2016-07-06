package com.zxjdev.smile;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;

import timber.log.Timber;

public class SmileApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        initThirdPartySDK();
    }

    private void initThirdPartySDK() {
        initLeanCloud();

        initTimber();
    }

    private void initLeanCloud() {
        AVOSCloud.initialize(this, BuildConfig.LEANCOULD_APP_ID, BuildConfig.LEANCOULD_APP_KEY);
    }

    private void initTimber() {
        if (BuildConfig.DEBUG) Timber.plant(new Timber.DebugTree());
    }
}


