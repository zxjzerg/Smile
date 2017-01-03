package com.zxjdev.smile.presentation.application.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.zxjdev.smile.presentation.application.SmileApplication;
import com.zxjdev.smile.presentation.application.di.component.ApplicationComponent;

import timber.log.Timber;

/**
 * 所有Activity的基类
 * Created by Andrew on 7/4/16.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected Context mContext = this;
    protected boolean mLogLifeCycle = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mLogLifeCycle) Timber.d("onCreate");
        initializeInjector();
    }

    /*@Override
    protected void onStart() {
        super.onStart();
        if (mLogLifeCycle) Timber.d("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mLogLifeCycle) Timber.d("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mLogLifeCycle) Timber.d("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mLogLifeCycle) Timber.d("onStop");
    }*/

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mLogLifeCycle) Timber.d("onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mLogLifeCycle) Timber.d("onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (mLogLifeCycle) Timber.d("onRestoreInstanceState");
    }

    /**
     * 配置依赖注入
     */
    protected abstract void initializeInjector();

    protected void showToast(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((SmileApplication) getApplication()).getApplicationComponent();
    }
}
