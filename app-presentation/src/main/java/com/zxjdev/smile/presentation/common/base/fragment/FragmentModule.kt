package com.zxjdev.smile.presentation.common.base.fragment

import android.support.v4.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.zxjdev.smile.presentation.common.di.scope.FragmentScope
import dagger.Module
import dagger.Provides

@Module
class FragmentModule {

    @Provides
    @FragmentScope
    internal fun provideRequestManager(fragment: Fragment): RequestManager {
        return Glide.with(fragment)
    }
}
