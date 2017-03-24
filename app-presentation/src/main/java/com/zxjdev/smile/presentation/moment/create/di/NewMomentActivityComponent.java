package com.zxjdev.smile.presentation.moment.create.di;

import com.zxjdev.smile.presentation.communal.base.activity.ActivityModule;
import com.zxjdev.smile.presentation.communal.di.scope.ActivityScope;
import com.zxjdev.smile.presentation.moment.create.NewMomentActivity;

import dagger.Subcomponent;

@Subcomponent(modules = {ActivityModule.class, NewMomentActivityModule.class})
@ActivityScope
public interface NewMomentActivityComponent {

  void inject(NewMomentActivity activity);
}
