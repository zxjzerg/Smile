package com.zxjdev.smile.presentation.common.base.fragment

import android.support.v4.app.Fragment

import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.zxjdev.smile.presentation.common.di.scope.FragmentScope

import dagger.Module
import dagger.Provides

@Module
class FragmentModule(private val fragment: Fragment) {

    @Provides
    @FragmentScope
    internal fun provideRequestManager(): RequestManager {
        return Glide.with(fragment)
    }
}
