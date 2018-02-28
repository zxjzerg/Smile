package com.zxjdev.smile.presentation.common.base.fragment;

import com.zxjdev.smile.presentation.common.util.image.GlideImageLoader;
import com.zxjdev.smile.presentation.common.util.image.ImageLoader;

import dagger.android.support.DaggerFragment;

public class BaseFragment extends DaggerFragment {

  private ImageLoader imageLoader;

  protected ImageLoader getImageLoader() {
    if (imageLoader == null) {
      imageLoader = new GlideImageLoader(this);
    }
    return imageLoader;
  }
}
