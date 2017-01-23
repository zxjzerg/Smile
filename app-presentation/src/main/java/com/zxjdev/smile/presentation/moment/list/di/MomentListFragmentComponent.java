package com.zxjdev.smile.presentation.moment.list.di;

import com.zxjdev.smile.presentation.application.di.scope.FragmentScope;
import com.zxjdev.smile.presentation.moment.list.MomentListFragment;

import dagger.Subcomponent;

@Subcomponent(
    modules = {
        MomentListFragmentModule.class
    })
@FragmentScope
public interface MomentListFragmentComponent {

    void inject(MomentListFragment fragment);
}