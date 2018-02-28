package com.zxjdev.smile.presentation.user.settings;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.zxjdev.smile.R;
import com.zxjdev.smile.presentation.common.SmileApplication;
import com.zxjdev.smile.presentation.common.base.fragment.BaseFragment;
import com.zxjdev.smile.presentation.infrastucture.splash.SplashActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingsFragment extends BaseFragment implements SettingsContract.View {

  public static final String TAG = SettingsFragment.class.getSimpleName();

  @BindView(R.id.btn_logout) Button btnLogout;

  @Inject SettingsPresenter settingsPresenter;

  public SettingsFragment() {
    setRetainInstance(true);
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_settings, container, false);
    ButterKnife.bind(this, view);
    settingsPresenter.takeView(this);
    return view;
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    settingsPresenter.dropView();
  }

  @OnClick(R.id.btn_logout)
  public void logoutClick() {
    settingsPresenter.handleLogout();
  }

  @Override
  public void onLogoutSuccess() {
    ((SmileApplication) getActivity().getApplication()).releaseUserComponent();

    Intent intent = new Intent(getActivity(), SplashActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
    startActivity(intent);
  }
}
