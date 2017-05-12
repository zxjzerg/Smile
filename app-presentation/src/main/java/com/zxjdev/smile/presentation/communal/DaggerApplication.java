package com.zxjdev.smile.presentation.communal;

import android.app.Application;

import com.zxjdev.smile.presentation.communal.di.component.ApplicationComponent;
import com.zxjdev.smile.presentation.communal.di.component.DaggerApplicationComponent;
import com.zxjdev.smile.presentation.communal.di.component.UserComponent;
import com.zxjdev.smile.presentation.communal.di.module.ApplicationModule;

public class DaggerApplication extends Application {

  private ApplicationComponent applicationComponent;
  private UserComponent userComponent;

  @Override
  public void onCreate() {
    super.onCreate();
    initInjector();
  }

  private void initInjector() {
    applicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
    if (getSharedPreferences("auth", MODE_PRIVATE).getBoolean("auto_login", false)) {
      initUserComponent();
    }
  }

  public ApplicationComponent getApplicationComponent() {
    return applicationComponent;
  }

  /**
   * Get instance of {@link UserComponent}. When null, will check if the user has login before and try to restore
   *  the component.
   */
  public UserComponent getUserComponent() {
    if (userComponent == null) {
      restoreUserComponent();
    }
    return userComponent;
  }

  private void restoreUserComponent() {
    if (getSharedPreferences("auth", MODE_PRIVATE).getBoolean("auto_login", false)) {
      userComponent = applicationComponent.getUserComponent();
    }
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
