package com.zxjdev.smile.presentation.application.di.module;

import com.zxjdev.smile.presentation.application.di.scope.FragmentScope;
import com.zxjdev.smile.presentation.moment.list.MomentAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class MomentsFragmentModule {

    @Provides
    @FragmentScope
    MomentAdapter provideMomentAdapter() {
        return new MomentAdapter();
    }
}
