package com.zxjdev.smile.presentation.common.util.image

import androidx.annotation.DrawableRes
import android.widget.ImageView

interface ImageLoader {

    fun loadImage(url: String, imageView: ImageView)

    fun loadImage(@DrawableRes res: Int, imageView: ImageView)

    fun loadCircleImage(url: String?, imageView: ImageView)

    fun loadCircleImage(@DrawableRes res: Int, imageView: ImageView)
}
