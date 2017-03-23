package com.zxjdev.smile.presentation.common.main.di;

import com.zxjdev.smile.presentation.application.base.fragment.FragmentModule;
import com.zxjdev.smile.presentation.common.main.MainActivity;
import com.zxjdev.smile.presentation.moment.list.di.MomentListFragmentComponent;
import com.zxjdev.smile.presentation.moment.list.di.MomentListFragmentModule;
import com.zxjdev.smile.presentation.user.settings.di.SettingsFragmentComponent;
import com.zxjdev.smile.presentation.user.settings.di.SettingsFragmentModule;

import dagger.Subcomponent;

@Subcomponent(modules = {MainActivityModule.class})
public interface MainActivityComponent {

    void inject(MainActivity activity);

    MomentListFragmentComponent getMomentsFragmentComponent(FragmentModule fragmentModule,
        MomentListFragmentModule momentListFragmentModule);

    SettingsFragmentComponent getSettingsFragmentComponent(SettingsFragmentModule settingsFragmentModule);
}
