package com.zxjdev.smile.presentation.common.base.fragment;

import android.support.v4.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.zxjdev.smile.presentation.common.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

@Module
public class FragmentModule {

  private Fragment fragment;

  public FragmentModule(Fragment fragment) {
    this.fragment = fragment;
  }

  @Provides
  @FragmentScope
  RequestManager provideRequestManager() {
    return Glide.with(fragment);
  }
}
