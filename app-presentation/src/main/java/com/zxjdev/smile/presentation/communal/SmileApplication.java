package com.zxjdev.smile.presentation.communal;

import android.app.Application;
import android.content.SharedPreferences;

import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVUser;
import com.facebook.stetho.Stetho;
import com.zxjdev.smile.BuildConfig;
import com.zxjdev.smile.data.moment.MomentEntity;
import com.zxjdev.smile.data.user.UserEntity;
import com.zxjdev.smile.presentation.communal.di.component.ApplicationComponent;
import com.zxjdev.smile.presentation.communal.di.component.DaggerApplicationComponent;
import com.zxjdev.smile.presentation.communal.di.component.UserComponent;
import com.zxjdev.smile.presentation.communal.di.module.ApplicationModule;

import timber.log.Timber;

public class SmileApplication extends Application {

  private ApplicationComponent applicationComponent;
  private UserComponent userComponent;
  private SharedPreferences preferences;

  @Override
  public void onCreate() {
    super.onCreate();

    initInjector();

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

  private void initInjector() {
    applicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
    if (getSharedPreferences("auth", MODE_PRIVATE).getBoolean("auto_login", false)) {
      initUserComponent();
    }
  }

  private void initStetho() {
    Stetho.initializeWithDefaults(this);
  }

  public ApplicationComponent getApplicationComponent() {
    return applicationComponent;
  }

  public UserComponent getUserComponent() {
    return userComponent;
  }

  public void initUserComponent() {
    userComponent = applicationComponent.getUserComponent();
    getSharedPreferences("auth", MODE_PRIVATE).edit().putBoolean("auto_login", true).apply();
  }

  public void releaseUserComponent() {
    userComponent = null;
    getSharedPreferences("auth", MODE_PRIVATE).edit().putBoolean("auto_login", false).apply();
  }
}


