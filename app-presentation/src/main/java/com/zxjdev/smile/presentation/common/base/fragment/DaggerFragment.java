package com.zxjdev.smile.presentation.common.base.fragment;

import android.content.Context;

import com.zxjdev.smile.presentation.common.DaggerApplication;
import com.zxjdev.smile.presentation.common.base.activity.DaggerActivity;

public abstract class DaggerFragment extends BaseFragment {

  @Override
  public void onAttach(Context context) {
    initDaggerComponent();
    super.onAttach(context);
  }

  @Override
  public void onDestroy() {
    releaseDaggerComponent();
    super.onDestroy();
  }

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
