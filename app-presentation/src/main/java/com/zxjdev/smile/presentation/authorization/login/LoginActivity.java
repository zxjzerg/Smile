package com.zxjdev.smile.presentation.authorization.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;

import com.zxjdev.smile.R;
import com.zxjdev.smile.presentation.common.SmileApplication;
import com.zxjdev.smile.presentation.common.base.activity.BaseActivity;
import com.zxjdev.smile.presentation.infrastucture.main.MainActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 登录界面
 * Created by Andrew on 7/5/16.
 */
public class LoginActivity extends BaseActivity implements LoginContract.View {

  @BindView(R.id.et_username) EditText etUsername;
  @BindView(R.id.et_password) EditText etPassword;
  @BindView(R.id.toolbar) Toolbar toolbar;

  @Inject LoginPresenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_login);
    ButterKnife.bind(this);
    initUi();

    presenter.takeView(this);
  }

  @Override
  protected void onDestroy() {
    presenter.dropView();
    super.onDestroy();
  }

  @OnClick(R.id.btn_login)
  public void loginClick() {
    presenter.handleLogin(etUsername.getText().toString(), etPassword.getText().toString());
  }

  @Override
  public void navigateToMain() {
    Intent intent = new Intent(context, MainActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
    startActivity(intent);
  }

  @Override
  public void initUserComponent() {
    ((SmileApplication) getApplication()).initUserComponent();
  }

  private void initUi() {
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setTitle(null);
  }
}
