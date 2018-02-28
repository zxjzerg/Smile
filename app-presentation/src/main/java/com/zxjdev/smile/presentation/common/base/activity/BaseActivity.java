package com.zxjdev.smile.presentation.common.base.activity;

import android.content.Context;
import android.widget.Toast;

import com.zxjdev.smile.presentation.common.util.image.GlideImageLoader;
import com.zxjdev.smile.presentation.common.util.image.ImageLoader;

import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity extends DaggerAppCompatActivity {

  protected Context context = this;

  protected void showToast(String message) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
  }

  private ImageLoader imageLoader;

  protected ImageLoader getImageLoader() {
    if (imageLoader == null) {
      imageLoader = new GlideImageLoader(this);
    }
    return imageLoader;
  }
}
