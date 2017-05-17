package com.zxjdev.smile.presentation.moment.list.di;

import com.zxjdev.smile.presentation.common.base.fragment.FragmentModule;
import com.zxjdev.smile.presentation.common.di.scope.FragmentScope;
import com.zxjdev.smile.presentation.moment.list.MomentListFragment;

import dagger.Subcomponent;

@Subcomponent(modules = {FragmentModule.class, MomentListFragmentModule.class})
@FragmentScope
public interface MomentListFragmentComponent {

  void inject(MomentListFragment fragment);
}
