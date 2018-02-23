package com.zxjdev.smile.presentation.moment.create.di;

import com.zxjdev.smile.presentation.common.base.activity.ActivityModule;
import com.zxjdev.smile.presentation.common.di.scope.ActivityScope;
import com.zxjdev.smile.presentation.moment.create.NewMomentActivity;

import dagger.Subcomponent;

@Subcomponent(modules = {ActivityModule.class})
@ActivityScope
public interface NewMomentActivityComponent {

  void inject(NewMomentActivity activity);
}
