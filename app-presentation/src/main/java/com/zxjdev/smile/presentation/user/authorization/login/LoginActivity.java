package com.zxjdev.smile.presentation.user.authorization.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.zxjdev.smile.R;
import com.zxjdev.smile.presentation.application.base.activity.ActivityModule;
import com.zxjdev.smile.presentation.common.main.MainActivity;
import com.zxjdev.smile.presentation.application.base.activity.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 登录界面
 * Created by Andrew on 7/5/16.
 */
public class LoginActivity extends BaseActivity implements LoginView {

    @BindView(R.id.et_username) EditText etUsername;
    @BindView(R.id.et_password) EditText etPassword;

    @Inject LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        presenter.setView(this);
    }

    @Override
    protected void initializeInjector() {
        getApplicationComponent().getActivityComponent(new ActivityModule(this)).inject(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destroy();
    }

    @OnClick(R.id.btn_login)
    public void loginClick() {
        presenter.handleLogin(etUsername.getText().toString(),
            etPassword.getText().toString());
    }

    @Override
    public Context context() {
        return context;
    }

    @Override
    public void navigateToMain() {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
