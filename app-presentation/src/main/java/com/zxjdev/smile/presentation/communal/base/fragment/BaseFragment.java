package com.zxjdev.smile.presentation.communal.base.fragment;

import android.support.v4.app.Fragment;

import com.zxjdev.smile.presentation.communal.util.image.GlideImageLoader;
import com.zxjdev.smile.presentation.communal.util.image.ImageLoader;

public class BaseFragment extends Fragment {

  private ImageLoader imageLoader;

  protected ImageLoader getImageLoader() {
    if (imageLoader == null) {
      imageLoader = new GlideImageLoader(this);
    }
    return imageLoader;
  }
}
