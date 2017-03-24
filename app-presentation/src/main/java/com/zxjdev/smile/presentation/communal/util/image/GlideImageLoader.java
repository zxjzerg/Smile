package com.zxjdev.smile.presentation.communal.util.image;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

public class GlideImageLoader implements ImageLoader {

  private Context context;
  private RequestManager requestManager;

  public GlideImageLoader(Context context, RequestManager requestManager) {
    this.context = context;
    this.requestManager = requestManager;
  }

  public GlideImageLoader(Activity activity) {
    this.context = activity.getApplicationContext();
    this.requestManager = Glide.with(activity);
  }

  public GlideImageLoader(Fragment fragment) {
    this.context = fragment.getActivity().getApplicationContext();
    this.requestManager = Glide.with(fragment);
  }

  @Override
  public void loadImage(String url, ImageView imageView) {
    requestManager.load(url).into(imageView);
  }

  @Override
  public void loadImage(@DrawableRes int res, ImageView imageView) {
    requestManager.load(res).into(imageView);
  }

  @Override
  public void loadCircleImage(String url, ImageView imageView) {
    requestManager.load(url).bitmapTransform(new CropCircleTransformation(context)).into(imageView);
  }

  @Override
  public void loadCircleImage(@DrawableRes int res, ImageView imageView) {
    requestManager.load(res).bitmapTransform(new CropCircleTransformation(context)).into(imageView);
  }
}
