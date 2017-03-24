package com.zxjdev.smile.presentation.communal.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.zxjdev.smile.presentation.communal.SmileApplication;
import com.zxjdev.smile.presentation.communal.di.component.ApplicationComponent;
import com.zxjdev.smile.presentation.communal.di.component.UserComponent;

public abstract class BaseDaggerActivity extends BaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initDaggerComponent();
  }

  /**
   * 配置依赖注入
   */
  protected abstract void initDaggerComponent();

  protected ApplicationComponent getApplicationComponent() {
    return ((SmileApplication) getApplication()).getApplicationComponent();
  }

  @Nullable
  protected UserComponent getUserComponent() {
    return ((SmileApplication) getApplication()).getUserComponent();
  }
}