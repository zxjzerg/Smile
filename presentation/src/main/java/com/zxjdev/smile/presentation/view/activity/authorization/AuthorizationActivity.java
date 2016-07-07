package com.zxjdev.smile.presentation.view.activity.authorization;

import android.os.Bundle;

import com.zxjdev.smile.presentation.di.component.AuthorizationComponent;
import com.zxjdev.smile.presentation.di.component.DaggerAuthorizationComponent;
import com.zxjdev.smile.presentation.di.module.ActivityModule;
import com.zxjdev.smile.presentation.view.activity.BaseActivity;

public abstract class AuthorizationActivity extends BaseActivity {

    private AuthorizationComponent mAuthorizationComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initInjector();
    }

    private void initInjector() {
        mAuthorizationComponent = DaggerAuthorizationComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(new ActivityModule(this))
                .build();
    }

    public AuthorizationComponent getComponent() {
        return mAuthorizationComponent;
    }
}
