package com.zxjdev.smile.presentation.infrastucture.main;

import com.zxjdev.smile.presentation.common.base.activity.ActivityModule;
import com.zxjdev.smile.presentation.common.di.scope.FragmentScope;
import com.zxjdev.smile.presentation.moment.list.MomentListFragment;
import com.zxjdev.smile.presentation.user.settings.SettingsFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(includes = ActivityModule.class)
public abstract class MainActivityModule {

  @FragmentScope
  @ContributesAndroidInjector
  abstract MomentListFragment momentListFragment();

  @FragmentScope
  @ContributesAndroidInjector
  abstract SettingsFragment settingsFragment();
}
