package com.zxjdev.smile.presentation.communal.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.zxjdev.smile.presentation.communal.DaggerApplication;
import com.zxjdev.smile.presentation.communal.di.component.ApplicationComponent;
import com.zxjdev.smile.presentation.communal.di.component.UserComponent;

public abstract class DaggerActivity extends BaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initDaggerComponent();
  }

  /** Implement this method to initialize your Component for this Activity. */
  protected abstract void initDaggerComponent();

  /** Implement this method to release your Component for this Activity.
   * <br/>This method can be left empty if there are no specified instances should be released manually */
  protected abstract void releaseDaggerComponent();

  protected ApplicationComponent getApplicationComponent() {
    return getDaggerApplication().getApplicationComponent();
  }

  @Nullable
  protected UserComponent getUserComponent() {
    return getDaggerApplication().getUserComponent();
  }

  public DaggerApplication getDaggerApplication() {
    if (getApplication() instanceof DaggerApplication) {
      return (DaggerApplication) getApplication();
    } else {
      throw new IllegalAccessError("Project's Application not extends DaggerApplication!");
    }
  }
}