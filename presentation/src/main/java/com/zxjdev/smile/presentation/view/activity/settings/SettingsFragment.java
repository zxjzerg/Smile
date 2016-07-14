package com.zxjdev.smile.presentation.view.activity.settings;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.zxjdev.smile.R;
import com.zxjdev.smile.presentation.presenter.settings.SettingsPresenter;
import com.zxjdev.smile.presentation.view.activity.authorization.SplashActivity;
import com.zxjdev.smile.presentation.view.activity.base.BaseFragment;
import com.zxjdev.smile.presentation.view.i.settings.ISettingsView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingsFragment extends BaseFragment implements ISettingsView {

    @BindView(R.id.btn_logout) Button mBtnLogout;

    @Inject SettingsPresenter mSettingsPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.buildCommonInjector().inject(this);

        mSettingsPresenter.setView(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mSettingsPresenter.destroy();
    }

    @OnClick(R.id.btn_logout)
    public void logoutClick() {
        mSettingsPresenter.handleLogout();
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
