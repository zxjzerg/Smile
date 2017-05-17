package com.zxjdev.smile.presentation.authorization.register.di;

import com.zxjdev.smile.presentation.common.base.activity.ActivityModule;
import com.zxjdev.smile.presentation.common.di.scope.ActivityScope;
import com.zxjdev.smile.presentation.authorization.register.RegisterActivity;

import dagger.Subcomponent;

@Subcomponent(modules = {ActivityModule.class, RegisterActivityModule.class})
@ActivityScope
public interface RegisterActivityComponent {

  void inject(RegisterActivity activity);
}
