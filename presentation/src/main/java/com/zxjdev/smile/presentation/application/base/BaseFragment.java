package com.zxjdev.smile.presentation.application.base;

import android.app.Fragment;
import android.os.Bundle;

import com.zxjdev.smile.presentation.application.SmileApplication;
import com.zxjdev.smile.presentation.application.di.component.ApplicationComponent;

public abstract class BaseFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeInjector();
    }

    /**
     * 配置依赖注入
     */
    protected abstract void initializeInjector();

    protected ApplicationComponent getApplicationComponent() {
        return ((SmileApplication) getActivity().getApplication()).getApplicationComponent();
    }
}
