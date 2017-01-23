package com.zxjdev.smile.presentation.application.base.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.zxjdev.smile.presentation.application.SmileApplication;
import com.zxjdev.smile.presentation.application.di.component.ApplicationComponent;

/**
 * 所有Activity的基类
 * Created by Andrew on 7/4/16.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeInjector();
    }

    /**
     * 配置依赖注入
     */
    protected abstract void initializeInjector();

    protected void showToast(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((SmileApplication) getApplication()).getApplicationComponent();
    }

    protected ActivityComponent getActivityComponent() {
        return getApplicationComponent().getActivityComponent(new ActivityModule(this));
    }
}
