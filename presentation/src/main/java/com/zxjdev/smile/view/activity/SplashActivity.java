package com.zxjdev.smile.view.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Button;

import com.zxjdev.smile.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 开屏界面
 * Created by Andrew on 7/4/16.
 */
public class SplashActivity extends BaseActivity {

    @BindView(R.id.btn_login) Button mBtnLogin;
    @BindView(R.id.btn_register) Button mBtnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        initUi();
    }

    private void initUi() {
        // 设置自定义的字体
        Typeface customFont = Typeface.createFromAsset(this.getAssets(), "fonts/AaPangYaer.ttf");
        mBtnLogin.setTypeface(customFont);
        mBtnRegister.setTypeface(customFont);
    }

    @OnClick(R.id.btn_login)
    void handleLoginCLick() {
        navigateToLogin();
    }

    private void navigateToLogin() {
        Intent login = new Intent(mContext, LoginActivity.class);
        startActivity(login);
        finish();
    }
}
