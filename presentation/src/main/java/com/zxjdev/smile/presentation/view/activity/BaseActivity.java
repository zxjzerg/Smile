package com.zxjdev.smile.presentation.view.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.zxjdev.smile.presentation.SmileApplication;
import com.zxjdev.smile.presentation.di.component.ApplicationComponent;

/**
 * 所有Activity的基类
 * Created by Andrew on 7/4/16.
 */
public abstract class BaseActivity extends Activity {

    protected Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void showToast(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((SmileApplication) getApplication()).getApplicationComponent();
    }
}
