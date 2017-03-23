package com.zxjdev.smile.presentation.application.base.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.zxjdev.smile.presentation.application.util.image.GlideImageLoader;
import com.zxjdev.smile.presentation.application.util.image.ImageLoader;

public abstract class BaseActivity extends AppCompatActivity {

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
