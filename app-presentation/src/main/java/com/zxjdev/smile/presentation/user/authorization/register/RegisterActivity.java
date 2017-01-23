package com.zxjdev.smile.presentation.user.authorization.register;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.zxjdev.smile.R;
import com.zxjdev.smile.presentation.application.base.activity.BaseActivity;
import com.zxjdev.smile.presentation.common.main.MainActivity;
import com.zxjdev.smile.presentation.user.authorization.register.di.RegisterActivityComponent;
import com.zxjdev.smile.presentation.user.authorization.register.di.RegisterActivityModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity implements RegisterContract.View {

    @BindView(R.id.et_username) EditText etUsername;
    @BindView(R.id.et_password) EditText etPassword;

    @Inject RegisterContract.Presenter presenter;

    private RegisterActivityComponent registerActivityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        presenter.setView(this);
    }

    @Override
    protected void initializeInjector() {
        registerActivityComponent = getActivityComponent().getRegisterComponent(
            new RegisterActivityModule());
        registerActivityComponent.inject(this);
    }

    @Override
    protected void onDestroy() {
        registerActivityComponent = null;
        super.onDestroy();
    }

    @OnClick(R.id.btn_register)
    void handleRegisterClick() {
        presenter.handleRegister(etUsername.getText().toString(), etPassword.getText().toString());
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
