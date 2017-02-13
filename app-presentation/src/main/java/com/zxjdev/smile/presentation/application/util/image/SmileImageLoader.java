package com.zxjdev.smile.presentation.application.util.image;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

import com.bumptech.glide.RequestManager;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

public class SmileImageLoader implements ImageLoader {

    private Context context;
    private RequestManager requestManager;

    public SmileImageLoader(Context context, RequestManager requestManager) {
        this.context = context;
        this.requestManager = requestManager;
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
        requestManager.load(url)
            .bitmapTransform(new CropCircleTransformation(context))
            .into(imageView);
    }

    @Override
    public void loadCircleImage(@DrawableRes int res, ImageView imageView) {
        requestManager.load(res)
            .bitmapTransform(new CropCircleTransformation(context))
            .into(imageView);
    }
}
