package com.zxjdev.smile.presentation.family.display;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zxjdev.smile.R;
import com.zxjdev.smile.presentation.communal.base.fragment.DaggerFragment;

import butterknife.ButterKnife;

public class FamilyFragment extends DaggerFragment {

  public static final String TAG = FamilyFragment.class.getSimpleName();

  @Override
  protected void initDaggerComponent() {

  }

  @Override
  protected void releaseDaggerComponent() {

  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
    @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_family, container, false);
    ButterKnife.bind(this, view);
    return view;
  }
}
