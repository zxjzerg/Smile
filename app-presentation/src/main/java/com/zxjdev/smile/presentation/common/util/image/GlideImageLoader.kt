package com.zxjdev.smile.presentation.common.util.image

import android.app.Activity
import android.content.Context
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import android.widget.ImageView

import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager

import jp.wasabeef.glide.transformations.CropCircleTransformation

class GlideImageLoader : ImageLoader {

    private var context: Context? = null
    private var requestManager: RequestManager? = null

    constructor(context: Context, requestManager: RequestManager) {
        this.context = context
        this.requestManager = requestManager
    }

    constructor(activity: Activity) {
        this.context = activity.applicationContext
        this.requestManager = Glide.with(activity)
    }

    constructor(fragment: Fragment) {
        this.context = fragment.activity?.applicationContext
        this.requestManager = Glide.with(fragment)
    }

    override fun loadImage(url: String, imageView: ImageView) {
        requestManager!!.load(url).into(imageView)
    }

    override fun loadImage(@DrawableRes res: Int, imageView: ImageView) {
        requestManager!!.load(res).into(imageView)
    }

    override fun loadCircleImage(url: String?, imageView: ImageView) {
        requestManager!!.load(url).transform(CropCircleTransformation(context)).into(imageView)
    }

    override fun loadCircleImage(@DrawableRes res: Int, imageView: ImageView) {
        requestManager!!.load(res).transform(CropCircleTransformation(context)).into(imageView)
    }
}
