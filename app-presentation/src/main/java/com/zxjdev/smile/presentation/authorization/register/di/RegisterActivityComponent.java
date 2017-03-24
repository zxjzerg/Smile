package com.zxjdev.smile.presentation.authorization.register.di;

import com.zxjdev.smile.presentation.communal.base.activity.ActivityModule;
import com.zxjdev.smile.presentation.communal.di.scope.ActivityScope;
import com.zxjdev.smile.presentation.authorization.register.RegisterActivity;

import dagger.Subcomponent;

@Subcomponent(modules = {ActivityModule.class, RegisterActivityModule.class})
@ActivityScope
public interface RegisterActivityComponent {

  void inject(RegisterActivity activity);
}
