package com.zxjdev.smile.presentation.application.base.fragment;

import android.app.Fragment;
import android.os.Bundle;

import com.zxjdev.smile.presentation.application.SmileApplication;
import com.zxjdev.smile.presentation.application.di.component.ApplicationComponent;

public abstract class BaseFragment extends Fragment {

    protected boolean initializedInjector = false;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (!initializedInjector) {
            initializeComponent();
            initializedInjector = true;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        releaseComponent();
        initializedInjector = true;
    }

    /**
     * 配置依赖注入
     */
    protected abstract void initializeComponent();

    protected abstract void releaseComponent();

    protected ApplicationComponent getApplicationComponent() {
        return ((SmileApplication) getActivity().getApplication()).getApplicationComponent();
    }
}
