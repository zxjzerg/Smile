package com.zxjdev.smile.presentation.common.base.activity

import android.content.Context
import android.widget.Toast

import com.zxjdev.smile.presentation.common.util.image.GlideImageLoader
import com.zxjdev.smile.presentation.common.util.image.ImageLoader

import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity() {

    protected var context: Context = this

    protected val imageLoader: ImageLoader by lazy {
        GlideImageLoader(this)
    }

    protected fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}
