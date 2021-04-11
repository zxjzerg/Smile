package com.zxjdev.smile.presentation.moment.list

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProviders
import com.zxjdev.smile.presentation.common.di.scope.FragmentScope
import dagger.Module
import dagger.Provides

@Module
class MomentListFragmentModule {

    @Provides
    fun provideMomentListViewModel(fragment: MomentListFragment): MomentListViewModel {
        return ViewModelProviders.of(fragment.requireActivity()).get(MomentListViewModel::class.java)
    }

    @Provides
    @FragmentScope
    fun provideLifecycleOwner(fragment: MomentListFragment): LifecycleOwner {
        return fragment.requireActivity()
    }
}