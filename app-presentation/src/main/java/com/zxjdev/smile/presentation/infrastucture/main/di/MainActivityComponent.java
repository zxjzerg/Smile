package com.zxjdev.smile.presentation.infrastucture.main.di;

import com.zxjdev.smile.presentation.common.base.activity.ActivityModule;
import com.zxjdev.smile.presentation.common.base.fragment.FragmentModule;
import com.zxjdev.smile.presentation.common.di.scope.ActivityScope;
import com.zxjdev.smile.presentation.infrastucture.main.MainActivity;
import com.zxjdev.smile.presentation.moment.list.di.MomentListFragmentComponent;
import com.zxjdev.smile.presentation.user.settings.di.SettingsFragmentComponent;

import dagger.Subcomponent;

@Subcomponent(modules = {ActivityModule.class})
@ActivityScope
public interface MainActivityComponent {

  void inject(MainActivity activity);

  MomentListFragmentComponent getMomentsFragmentComponent(FragmentModule fragmentModule);

  SettingsFragmentComponent getSettingsFragmentComponent();
}
