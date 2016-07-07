package com.zxjdev.smile.presentation.view.activity.authorization;

import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;

import com.zxjdev.smile.R;
import com.zxjdev.smile.presentation.presenter.RegisterPresenter;
import com.zxjdev.smile.presentation.view.i.IRegisterView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AuthorizationActivity implements IRegisterView {

    @BindView(R.id.et_username) EditText mEtUsername;
    @BindView(R.id.et_password) EditText mEtPassword;

    @Inject RegisterPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ButterKnife.bind(this);
        getComponent().inject(this);

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
}
