package com.zxjdev.smile.presentation.moment.list

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.ViewModelProviders
import com.zxjdev.smile.presentation.common.di.scope.FragmentScope
import dagger.Module
import dagger.Provides

@Module
class MomentListFragmentModule {

    @Provides
    fun provideMomentListViewModel(fragment: MomentListFragment): MomentListViewModel {
        return ViewModelProviders.of(fragment.activity).get(MomentListViewModel::class.java)
    }

    @Provides
    @FragmentScope
    fun provideLifecycleOwner(fragment: MomentListFragment): LifecycleOwner {
        return fragment.activity
    }
}