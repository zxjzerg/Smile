package com.zxjdev.smile.presentation.common.main.di;

import com.zxjdev.smile.presentation.moment.list.di.MomentListFragmentComponent;
import com.zxjdev.smile.presentation.application.base.activity.ActivityModule;
import com.zxjdev.smile.presentation.moment.list.di.MomentListFragmentModule;
import com.zxjdev.smile.presentation.application.di.scope.ActivityScope;
import com.zxjdev.smile.presentation.common.main.MainActivity;

import dagger.Subcomponent;

@Subcomponent(
    modules = {
        ActivityModule.class, MainActivityModule.class
    })
@ActivityScope
public interface MainActivityComponent {

    MomentListFragmentComponent getMomentsFragmentComponent(MomentListFragmentModule module);

    void inject(MainActivity activity);
}
