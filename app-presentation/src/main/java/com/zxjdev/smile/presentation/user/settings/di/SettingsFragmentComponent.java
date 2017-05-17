package com.zxjdev.smile.presentation.user.settings.di;

import com.zxjdev.smile.presentation.common.di.scope.FragmentScope;
import com.zxjdev.smile.presentation.user.settings.SettingsFragment;

import dagger.Subcomponent;

@Subcomponent(modules = {
  SettingsFragmentModule.class
})
@FragmentScope
public interface SettingsFragmentComponent {

  void inject(SettingsFragment fragment);
}
