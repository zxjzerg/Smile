package com.zxjdev.smile.presentation.application.util.image;

import android.support.annotation.DrawableRes;
import android.widget.ImageView;

public interface ImageLoader {

  void loadImage(String url, ImageView imageView);

  void loadImage(@DrawableRes int res, ImageView imageView);

  void loadCircleImage(String url, ImageView imageView);

  void loadCircleImage(@DrawableRes int res, ImageView imageView);
}
