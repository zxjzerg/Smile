package com.zxjdev.smile.presentation.application.di.component;

import com.zxjdev.smile.presentation.application.di.module.MomentsFragmentModule;
import com.zxjdev.smile.presentation.application.di.scope.FragmentScope;
import com.zxjdev.smile.presentation.moment.list.MomentsFragment;

import dagger.Subcomponent;

@Subcomponent(
    modules = {
        MomentsFragmentModule.class
    })
@FragmentScope
public interface MomentsFragmentComponent {

    void inject(MomentsFragment fragment);
}
