package com.zxjdev.smile.presentation.user.authorization.register;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.zxjdev.smile.R;
import com.zxjdev.smile.presentation.application.di.module.ActivityModule;
import com.zxjdev.smile.presentation.common.main.MainActivity;
import com.zxjdev.smile.presentation.application.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity implements IRegisterView {

    @BindView(R.id.et_username) EditText mEtUsername;
    @BindView(R.id.et_password) EditText mEtPassword;

    @Inject RegisterPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        mPresenter.setView(this);
    }

    @Override
    protected void initializeInjector() {
        getApplicationComponent().plus(new ActivityModule(this)).inject(this);
    }

    @OnClick(R.id.btn_register)
    void handleRegisterClick() {
        mPresenter.handleRegister(mEtUsername.getText().toString(),
            mEtPassword.getText().toString());
    }

    @Override
    public Context context() {
        return mContext;
    }

    @Override
    public void toast(String message) {
        showToast(message);
    }

    @Override
    public void navigateToMain() {
        Intent intent = new Intent(mContext, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
