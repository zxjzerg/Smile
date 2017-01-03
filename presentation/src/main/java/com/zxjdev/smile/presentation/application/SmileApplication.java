package com.zxjdev.smile.presentation.application;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVUser;
import com.zxjdev.smile.BuildConfig;
import com.zxjdev.smile.data.moment.MomentEntity;
import com.zxjdev.smile.data.user.UserEntity;
import com.zxjdev.smile.presentation.application.di.component.ApplicationComponent;
import com.zxjdev.smile.presentation.application.di.component.DaggerApplicationComponent;
import com.zxjdev.smile.presentation.application.di.module.ApplicationModule;

import timber.log.Timber;

public class SmileApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initInjector();

        initThirdPartySDK();
    }

    private void initThirdPartySDK() {
        initLeanCloud();

        initTimber();
    }

    private void initLeanCloud() {
        // 使运行时获得用户对象都未UserEntity, 必须在initialize之前调用
        AVUser.alwaysUseSubUserClass(UserEntity.class);

        // 注册子类化的类
        AVObject.registerSubclass(MomentEntity.class);

        // 初始化LeanCloud
        AVOSCloud.initialize(this, BuildConfig.LEANCOULD_APP_ID, BuildConfig.LEANCOULD_APP_KEY);
    }

    private void initTimber() {
        if (BuildConfig.DEBUG) Timber.plant(new Timber.DebugTree());
    }

    private void initInjector() {
        mApplicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(new ApplicationModule(this))
            .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}


