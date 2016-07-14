package com.zxjdev.smile.presentation.view.activity.authorization;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.zxjdev.smile.R;
import com.zxjdev.smile.presentation.presenter.authorization.RegisterPresenter;
import com.zxjdev.smile.presentation.view.activity.MainActivity;
import com.zxjdev.smile.presentation.view.activity.base.BaseActivity;
import com.zxjdev.smile.presentation.view.i.authorization.IRegisterView;

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
        super.buildCommonInjector().inject(this);

        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        mPresenter.setView(this);
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
