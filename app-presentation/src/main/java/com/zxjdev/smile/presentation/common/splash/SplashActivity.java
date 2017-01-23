package com.zxjdev.smile.presentation.common.splash;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zxjdev.smile.R;
import com.zxjdev.smile.presentation.application.base.activity.BaseActivity;
import com.zxjdev.smile.presentation.common.main.MainActivity;
import com.zxjdev.smile.presentation.common.splash.di.SplashActivityComponent;
import com.zxjdev.smile.presentation.common.splash.di.SplashActivityhModule;
import com.zxjdev.smile.presentation.user.authorization.login.LoginActivity;
import com.zxjdev.smile.presentation.user.authorization.register.RegisterActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 开屏界面
 * Created by Andrew on 7/4/16.
 */
public class SplashActivity extends BaseActivity implements SplashContract.View {

    @BindView(R.id.btn_login) Button btnLogin;
    @BindView(R.id.btn_register) Button btnRegister;

    @Inject SplashContract.Presenter presenter;

    private SplashActivityComponent splashActivityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        initUi();

        presenter.setView(this);
        presenter.handleAutoLogin();
    }

    @Override
    protected void initializeInjector() {
        splashActivityComponent = getActivityComponent().getSplashComponent(
            new SplashActivityhModule());
        splashActivityComponent.inject(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destroy();
        splashActivityComponent = null;
    }

    private void initUi() {
        // 设置自定义的字体
        Typeface customFont = Typeface.createFromAsset(this.getAssets(), "fonts/AaPangYaer.ttf");
        btnLogin.setTypeface(customFont);
        btnRegister.setTypeface(customFont);
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
        Intent login = new Intent(context, LoginActivity.class);
        startActivity(login);
    }

    private void navigateToRegister() {
        Intent login = new Intent(context, RegisterActivity.class);
        startActivity(login);
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

    @Override
    public void showButtons() {
        btnLogin.setVisibility(View.VISIBLE);
        btnRegister.setVisibility(View.VISIBLE);
    }
}