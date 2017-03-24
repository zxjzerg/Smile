package com.zxjdev.smile.presentation.basic.main.di;

import com.zxjdev.smile.presentation.communal.base.activity.ActivityModule;
import com.zxjdev.smile.presentation.communal.base.fragment.FragmentModule;
import com.zxjdev.smile.presentation.communal.di.scope.ActivityScope;
import com.zxjdev.smile.presentation.basic.main.MainActivity;
import com.zxjdev.smile.presentation.moment.list.di.MomentListFragmentComponent;
import com.zxjdev.smile.presentation.moment.list.di.MomentListFragmentModule;
import com.zxjdev.smile.presentation.user.settings.di.SettingsFragmentComponent;
import com.zxjdev.smile.presentation.user.settings.di.SettingsFragmentModule;

import dagger.Subcomponent;

@Subcomponent(modules = {ActivityModule.class, MainActivityModule.class})
@ActivityScope
public interface MainActivityComponent {

  void inject(MainActivity activity);

  MomentListFragmentComponent getMomentsFragmentComponent(FragmentModule fragmentModule,
    MomentListFragmentModule momentListFragmentModule);

  SettingsFragmentComponent getSettingsFragmentComponent(SettingsFragmentModule settingsFragmentModule);
}
