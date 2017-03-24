package com.zxjdev.smile.presentation.moment.list.di;

import com.zxjdev.smile.presentation.communal.di.scope.FragmentScope;
import com.zxjdev.smile.presentation.moment.list.MomentListContract;
import com.zxjdev.smile.presentation.moment.list.MomentListPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MomentListFragmentModule {

  private MomentListContract.View view;

  public MomentListFragmentModule(MomentListContract.View view) {
    this.view = view;
  }

  @Provides
  @FragmentScope
  MomentListContract.View provideView() {
    return view;
  }

  @Provides
  @FragmentScope
  MomentListContract.Presenter providePresenter(MomentListPresenter presenter) {
    return presenter;
  }
}
