package com.zxjdev.smile.presentation.application.base.activity;

import android.os.Bundle;

import com.zxjdev.smile.presentation.application.SmileApplication;
import com.zxjdev.smile.presentation.application.di.component.ApplicationComponent;

public abstract class BaseDaggerActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDaggerComponent();
    }

    /**
     * 配置依赖注入
     */
    protected abstract void initDaggerComponent();

    protected ApplicationComponent getApplicationComponent() {
        return ((SmileApplication) getApplication()).getApplicationComponent();
    }

    protected ActivityComponent getActivityComponent() {
        return getApplicationComponent().getActivityComponent(new ActivityModule(this));
    }
}