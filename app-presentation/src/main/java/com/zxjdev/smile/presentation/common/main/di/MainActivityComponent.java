package com.zxjdev.smile.presentation.common.main.di;

import com.zxjdev.smile.presentation.application.base.activity.ActivityModule;
import com.zxjdev.smile.presentation.common.main.MainActivity;
import com.zxjdev.smile.presentation.moment.list.di.MomentListFragmentComponent;
import com.zxjdev.smile.presentation.moment.list.di.MomentListFragmentModule;
import com.zxjdev.smile.presentation.user.settings.di.SettingsFragmentComponent;
import com.zxjdev.smile.presentation.user.settings.di.SettingsFragmentModule;

import dagger.Subcomponent;

@Subcomponent(
    modules = {
        ActivityModule.class, MainActivityModule.class
    })
public interface MainActivityComponent {

    void inject(MainActivity activity);

    MomentListFragmentComponent getMomentsFragmentComponent(MomentListFragmentModule momentListFragmentModule);

    SettingsFragmentComponent getSettingsFragmentComponent(SettingsFragmentModule settingsFragmentModule);
}
