package com.zxjdev.smile.presentation.view.activity.base;

import android.app.Fragment;

import com.zxjdev.smile.presentation.di.component.ViewCommonComponent;

public class BaseFragment extends Fragment {

    protected ViewCommonComponent buildCommonInjector() {
        return ((BaseActivity) getActivity()).buildCommonInjector();
    }
}
