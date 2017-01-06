package com.zxjdev.smile.presentation.application.base;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zxjdev.smile.presentation.application.SmileApplication;
import com.zxjdev.smile.presentation.application.di.component.ApplicationComponent;

import timber.log.Timber;

public abstract class BaseFragment extends Fragment {

    protected boolean mLogLifeCycle = true;
    protected String mClassName = BaseFragment.this.getClass().getSimpleName();

    protected boolean mInitializedInjector = false;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (mLogLifeCycle) Timber.d("%s onAttach", mClassName);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mLogLifeCycle) Timber.d("%s onCreate", mClassName);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
        ViewGroup container,
        Bundle savedInstanceState) {
        if (mLogLifeCycle) Timber.d("%s onCreateView", mClassName);
        // nothing at all
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (mLogLifeCycle) Timber.d("%s onActivityCreated", mClassName);

        if (!mInitializedInjector) {
            initializeComponent();
            mInitializedInjector = true;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mLogLifeCycle) Timber.d("%s onStart", mClassName);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mLogLifeCycle) Timber.d("%s onResume", mClassName);
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mLogLifeCycle) Timber.d("%s onPause", mClassName);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mLogLifeCycle) Timber.d("%s onStop", mClassName);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mLogLifeCycle) Timber.d("%s onDestroyView", mClassName);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mLogLifeCycle) Timber.d("%s onDestroy", mClassName);

        releaseComponent();
        mInitializedInjector = true;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (mLogLifeCycle) Timber.d("%s onDetach", mClassName);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mLogLifeCycle) Timber.d("%s onSaveInstanceState", mClassName);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (mLogLifeCycle) Timber.d("%s onViewStateRestored", mClassName);
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
