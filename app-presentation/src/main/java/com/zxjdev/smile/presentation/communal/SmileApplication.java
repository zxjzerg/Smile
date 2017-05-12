package com.zxjdev.smile.presentation.communal;

import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVUser;
import com.facebook.stetho.Stetho;
import com.zxjdev.smile.BuildConfig;
import com.zxjdev.smile.data.moment.MomentEntity;
import com.zxjdev.smile.data.user.UserEntity;

import timber.log.Timber;

public class SmileApplication extends DaggerApplication {

  @Override
  public void onCreate() {
    super.onCreate();

    initThirdPartySDK();
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
}


