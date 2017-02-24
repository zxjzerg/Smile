package com.zxjdev.smile.presentation.application.base.fragment;

import android.app.Fragment;
import android.os.Bundle;

import com.zxjdev.smile.presentation.application.SmileApplication;
import com.zxjdev.smile.presentation.application.di.component.ApplicationComponent;

public abstract class BaseFragment extends Fragment {

    protected boolean componentInitialized = false;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (!componentInitialized) {
            initDaggerComponent();
            componentInitialized = true;

            onDependencyReady();

            onInitialized();
        } else {
            onDependencyReady();
        }
    }

    @Override
    public void onDestroy() {
        releaseDaggerComponent();
        componentInitialized = false;
        super.onDestroy();
    }

    /**
     * Called after view is created and all dependencies is ready. Share same lifecycle with onActivityCreated().
     */
    protected void onDependencyReady() {

    }

    /**
     * Called after view is created and all dependencies is ready. Only called once if activity is
     * not destroyed.
     */
    protected void onInitialized() {

    }

    protected abstract void initDaggerComponent();

    protected abstract void releaseDaggerComponent();

    protected ApplicationComponent getApplicationComponent() {
        return ((SmileApplication) getActivity().getApplication()).getApplicationComponent();
    }
}
