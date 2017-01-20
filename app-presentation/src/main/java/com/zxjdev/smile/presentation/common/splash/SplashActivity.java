package com.zxjdev.smile.presentation.common.splash;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zxjdev.smile.R;
import com.zxjdev.smile.presentation.application.di.module.ActivityModule;
import com.zxjdev.smile.presentation.user.authorization.login.LoginActivity;
import com.zxjdev.smile.presentation.user.authorization.register.RegisterActivity;
import com.zxjdev.smile.presentation.common.main.MainActivity;
import com.zxjdev.smile.presentation.application.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 开屏界面
 * Created by Andrew on 7/4/16.
 */
public class SplashActivity extends BaseActivity implements ISplashView {

    @BindView(R.id.btn_login) Button mBtnLogin;
    @BindView(R.id.btn_register) Button mBtnRegister;

    @Inject SplashPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        initUi();

        mPresenter.setView(this);
        mPresenter.handleAutoLogin();
    }

    @Override
    protected void initializeInjector() {
        getApplicationComponent().plus(new ActivityModule(this)).inject(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.destroy();
    }

    private void initUi() {
        // 设置自定义的字体
        Typeface customFont = Typeface.createFromAsset(this.getAssets(), "fonts/AaPangYaer.ttf");
        mBtnLogin.setTypeface(customFont);
        mBtnRegister.setTypeface(customFont);
    }

    @OnClick(R.id.btn_login)
    public void loginCLick() {
        navigateToLogin();
    }

    @OnClick(R.id.btn_register)
    public void registerClick() {
        navigateToRegister();
    }

    private void navigateToLogin() {
        Intent login = new Intent(mContext, LoginActivity.class);
        startActivity(login);
    }

    private void navigateToRegister() {
        Intent login = new Intent(mContext, RegisterActivity.class);
        startActivity(login);
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

    @Override
    public void showButtons() {
        mBtnLogin.setVisibility(View.VISIBLE);
        mBtnRegister.setVisibility(View.VISIBLE);
    }
}
