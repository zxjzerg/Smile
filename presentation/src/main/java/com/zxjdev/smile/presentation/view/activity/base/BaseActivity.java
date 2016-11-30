package com.zxjdev.smile.presentation.view.activity.base;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.zxjdev.smile.presentation.SmileApplication;
import com.zxjdev.smile.presentation.di.component.ApplicationComponent;
import com.zxjdev.smile.presentation.di.component.DaggerViewCommonComponent;
import com.zxjdev.smile.presentation.di.component.ViewCommonComponent;
import com.zxjdev.smile.presentation.di.module.ActivityModule;

/**
 * 所有Activity的基类
 * Created by Andrew on 7/4/16.
 */
public abstract class BaseActivity extends AppCompatActivity {

    public final String TAG = this.getClass().getSimpleName();

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

    /**
     * 创建一个View层通用的Component用于依赖注入,
     * 一般在onCreate方法中调用buildCommonInjector().inject(this)
     *
     * @return 通用的Component对象
     */
    protected ViewCommonComponent buildCommonInjector() {
        return DaggerViewCommonComponent.builder()
            .applicationComponent(this.getApplicationComponent())
            .activityModule(new ActivityModule(this))
            .build();
    }

    protected void addFragment(@IdRes int container, Fragment fragment) {
        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        fragmentTransaction.add(container, fragment);
        fragmentTransaction.commit();
    }

    protected void replaceFragment(@IdRes int container, Fragment fragment, String tag) {
        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        fragmentTransaction.replace(container, fragment, tag);
        fragmentTransaction.commit();
    }

    protected void replaceFragment(@IdRes int container, Fragment fragment) {
        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        fragmentTransaction.replace(container, fragment);
        fragmentTransaction.commit();
    }
}
