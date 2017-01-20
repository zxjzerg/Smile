package com.zxjdev.smile.presentation.application.di.component;

import com.zxjdev.smile.presentation.application.di.module.MomentsFragmentModule;
import com.zxjdev.smile.presentation.moment.list.MomentsFragment;

import dagger.Subcomponent;

@Subcomponent(
    modules = {
        MomentsFragmentModule.class
    })
public interface MomentsFragmentComponent {

    void inject(MomentsFragment fragment);
}
