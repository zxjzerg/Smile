package com.zxjdev.smile.presentation.application.base.fragment;

import android.os.Bundle;

public abstract class DaggerBaseFragment extends BaseFragment {

    protected boolean componentCreated = false;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (!componentCreated) {
            initDaggerComponent();
            componentCreated = true;
        }
        onDependencyCreated();
    }

    @Override
    public void onDestroy() {
        releaseDaggerComponent();
        componentCreated = false;
        super.onDestroy();
    }

    /**
     * Called after view is created and all dependencies is ready. Share same lifecycle with onActivityCreated().
     */
    protected void onDependencyCreated() {

    }

    protected abstract void initDaggerComponent();

    protected abstract void releaseDaggerComponent();
}
