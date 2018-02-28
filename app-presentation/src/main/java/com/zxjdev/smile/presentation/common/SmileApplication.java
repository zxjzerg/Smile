package com.zxjdev.smile.presentation.common;

import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVUser;
import com.facebook.stetho.Stetho;
import com.zxjdev.smile.BuildConfig;
import com.zxjdev.smile.data.moment.entity.MomentEntity;
import com.zxjdev.smile.data.user.entity.UserEntity;
import com.zxjdev.smile.presentation.common.di.component.DaggerApplicationComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import timber.log.Timber;

public class SmileApplication extends DaggerApplication {

  @Override
  public void onCreate() {
    super.onCreate();

    initThirdPartySDK();
  }

  @Override
  protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
    return DaggerApplicationComponent.builder().application(this).build();
  }

  private void initThirdPartySDK() {
    initLeanCloud();

    initTimber();

    initStetho();
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

  private void initStetho() {
    Stetho.initializeWithDefaults(this);
  }

  public void initUserComponent() {
    getSharedPreferences("auth", MODE_PRIVATE).edit().putBoolean("auto_login", true).apply();
  }

  public void releaseUserComponent() {
    getSharedPreferences("auth", MODE_PRIVATE).edit().putBoolean("auto_login", false).apply();
  }
}


