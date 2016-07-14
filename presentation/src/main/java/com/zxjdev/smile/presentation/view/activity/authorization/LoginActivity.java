package com.zxjdev.smile.presentation.view.activity.authorization;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.zxjdev.smile.R;
import com.zxjdev.smile.presentation.presenter.authorization.LoginPresenter;
import com.zxjdev.smile.presentation.view.activity.MainActivity;
import com.zxjdev.smile.presentation.view.activity.base.BaseActivity;
import com.zxjdev.smile.presentation.view.i.authorization.ILoginView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 登录界面
 * Created by Andrew on 7/5/16.
 */
public class LoginActivity extends BaseActivity implements ILoginView {

    @BindView(R.id.et_username) EditText mEtUsername;
    @BindView(R.id.et_password) EditText mEtPassword;

    @Inject LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.buildCommonInjector().inject(this);

        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mPresenter.setView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.destroy();
    }

    @OnClick(R.id.btn_login)
    public void loginClick() {
        mPresenter.handleLoginClick(mEtUsername.getText().toString(),
                mEtPassword.getText().toString());
    }

    @Override
    public Context context() {
        return mContext;
    }

    @Override
    public void navigateToMain() {
        Intent intent = new Intent(mContext, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
