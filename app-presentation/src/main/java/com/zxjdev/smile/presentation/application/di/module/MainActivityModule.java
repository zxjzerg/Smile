package com.zxjdev.smile.presentation.application.di.module;

import com.zxjdev.smile.presentation.application.di.scope.ActivityScope;
import com.zxjdev.smile.presentation.moment.list.MomentAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    @Provides
    @ActivityScope
    MomentAdapter provideMomentAdapter() {
        return new MomentAdapter();
    }
}
