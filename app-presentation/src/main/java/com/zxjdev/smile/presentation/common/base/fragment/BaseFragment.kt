package com.zxjdev.smile.presentation.common.base.fragment

import com.zxjdev.smile.presentation.common.util.image.GlideImageLoader
import com.zxjdev.smile.presentation.common.util.image.ImageLoader

import dagger.android.support.DaggerFragment

open class BaseFragment : DaggerFragment() {

    protected val imageLoader: ImageLoader by lazy {
        GlideImageLoader(this)
    }
}
