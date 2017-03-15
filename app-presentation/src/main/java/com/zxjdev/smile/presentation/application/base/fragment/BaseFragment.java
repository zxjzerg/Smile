package com.zxjdev.smile.presentation.application.base.fragment;

import android.app.Fragment;

import com.zxjdev.smile.presentation.application.util.image.GlideImageLoader;
import com.zxjdev.smile.presentation.application.util.image.ImageLoader;

public class BaseFragment extends Fragment {

    protected ImageLoader getImageLoader() {
        return new GlideImageLoader(this);
    }
}
