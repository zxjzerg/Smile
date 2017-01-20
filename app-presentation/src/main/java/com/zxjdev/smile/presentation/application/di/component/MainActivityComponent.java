package com.zxjdev.smile.presentation.application.di.component;

import com.zxjdev.smile.presentation.application.di.module.ActivityModule;
import com.zxjdev.smile.presentation.application.di.module.MainActivityModule;
import com.zxjdev.smile.presentation.application.di.module.MomentsFragmentModule;
import com.zxjdev.smile.presentation.application.di.scope.ActivityScope;
import com.zxjdev.smile.presentation.common.main.MainActivity;
import com.zxjdev.smile.presentation.moment.list.MomentsFragment;

import dagger.Subcomponent;

@Subcomponent(
    modules = {
        ActivityModule.class, MainActivityModule.class
    })
@ActivityScope
public interface MainActivityComponent {

    MomentsFragmentComponent plus(MomentsFragmentModule module);

    void inject(MainActivity activity);

    void inject(MomentsFragment fragment);
}
