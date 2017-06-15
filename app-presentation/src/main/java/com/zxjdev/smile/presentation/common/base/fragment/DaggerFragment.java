package com.zxjdev.smile.presentation.common.base.fragment;

import android.os.Bundle;

import com.zxjdev.smile.presentation.common.DaggerApplication;
import com.zxjdev.smile.presentation.common.base.activity.DaggerActivity;

public abstract class DaggerFragment extends BaseFragment {

  protected boolean componentCreated = false;

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    if (!componentCreated) {
      initDaggerComponent();
      componentCreated = true;
    }
    onDependencyCreated();
  }

  @Override
  public void onDestroy() {
    releaseDaggerComponent();
    componentCreated = false;
    super.onDestroy();
  }

  /** Called after view is created and all dependencies is ready.
   * <br/>Share same lifecycle with onActivityCreated(). */
  protected void onDependencyCreated() {}

  /** Implement this method to initialize your Component for this Fragment. */
  protected abstract void initDaggerComponent();

  /** Implement this method to release your Component for this Fragment.
   * <br/>This method can be left empty if there are no specified instances should be released manually */
  protected abstract void releaseDaggerComponent();

  protected DaggerApplication getDaggerApplication() {
    return getDaggerActivity().getDaggerApplication();
  }

  protected DaggerActivity getDaggerActivity() {
    if (getActivity() == null) {
      throw new IllegalStateException("Cannot get Activity!");
    }

    if (getActivity() instanceof DaggerActivity) {
      return (DaggerActivity) getActivity();
    } else {
      throw new IllegalAccessError("This fragment not contained in DaggerActivity!");
    }
  }
}