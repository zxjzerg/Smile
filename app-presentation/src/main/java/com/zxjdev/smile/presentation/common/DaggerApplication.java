package com.zxjdev.smile.presentation.common;

import android.app.Application;

import com.zxjdev.smile.presentation.common.di.component.ApplicationComponent;
import com.zxjdev.smile.presentation.common.di.component.DaggerApplicationComponent;

public class DaggerApplication extends Application {

  private ApplicationComponent applicationComponent;

  @Override
  public void onCreate() {
    super.onCreate();
    initInjector();
  }

  private void initInjector() {
    applicationComponent = DaggerApplicationComponent.builder().application(this).build();
  }

  public ApplicationComponent getApplicationComponent() {
    return applicationComponent;
  }

  public void initUserComponent() {
    getSharedPreferences("auth", MODE_PRIVATE).edit().putBoolean("auto_login", true).apply();
  }

  public void releaseUserComponent() {
    getSharedPreferences("auth", MODE_PRIVATE).edit().putBoolean("auto_login", false).apply();
  }
}
