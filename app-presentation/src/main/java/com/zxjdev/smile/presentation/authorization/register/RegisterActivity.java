package com.zxjdev.smile.presentation.authorization.register;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;

import com.zxjdev.smile.R;
import com.zxjdev.smile.presentation.authorization.register.di.RegisterActivityComponent;
import com.zxjdev.smile.presentation.common.DaggerApplication;
import com.zxjdev.smile.presentation.common.base.activity.ActivityModule;
import com.zxjdev.smile.presentation.common.base.activity.DaggerActivity;
import com.zxjdev.smile.presentation.infrastucture.main.MainActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends DaggerActivity implements RegisterContract.View {

  @BindView(R.id.et_username) EditText etUsername;
  @BindView(R.id.et_password) EditText etPassword;
  @BindView(R.id.toolbar) Toolbar toolbar;

  @Inject RegisterPresenter presenter;

  private RegisterActivityComponent registerActivityComponent;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_register);
    ButterKnife.bind(this);
    initUi();

    presenter.takeView(this);
  }

  @Override
  protected void initDaggerComponent() {
    registerActivityComponent = getApplicationComponent().getRegisterActivityComponent(new ActivityModule(this));
    registerActivityComponent.inject(this);
  }

  @Override
  protected void releaseDaggerComponent() {

  }

  @Override
  protected void onDestroy() {
    registerActivityComponent = null;
    presenter.dropView();
    super.onDestroy();
  }

  @OnClick(R.id.btn_register)
  void handleRegisterClick() {
    presenter.handleRegister(etUsername.getText().toString(), etPassword.getText().toString());
  }

  @Override
  public void navigateToMain() {
    Intent intent = new Intent(context, MainActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
    startActivity(intent);
  }

  @Override
  public void initUserComponent() {
    ((DaggerApplication) getApplication()).initUserComponent();
  }

  private void initUi() {
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setTitle(null);
  }
}
