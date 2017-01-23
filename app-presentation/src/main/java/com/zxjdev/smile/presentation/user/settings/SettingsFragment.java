package com.zxjdev.smile.presentation.user.settings;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.zxjdev.smile.R;
import com.zxjdev.smile.presentation.application.base.fragment.BaseFragment;
import com.zxjdev.smile.presentation.application.base.activity.ActivityModule;
import com.zxjdev.smile.presentation.common.splash.SplashActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingsFragment extends BaseFragment implements SettingsView {

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

    @Override
    protected void initializeComponent() {
        getApplicationComponent().getActivityComponent(new ActivityModule(getActivity())).inject(this);
    }

    @Override
    protected void releaseComponent() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
        ViewGroup container,
        Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        settingsPresenter.setView(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        settingsPresenter.destroy();
    }

    @OnClick(R.id.btn_logout)
    public void logoutClick() {
        settingsPresenter.handleLogout();
    }

    @Override
    public Context context() {
        return getActivity();
    }

    @Override
    public void navigateToSplash() {
        Intent intent = new Intent(getActivity(), SplashActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
