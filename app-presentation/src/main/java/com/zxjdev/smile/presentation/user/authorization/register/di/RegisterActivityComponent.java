package com.zxjdev.smile.presentation.user.authorization.register.di;

import com.zxjdev.smile.presentation.user.authorization.register.RegisterActivity;

import dagger.Subcomponent;

@Subcomponent(modules = {
  RegisterActivityModule.class
})
public interface RegisterActivityComponent {

  void inject(RegisterActivity activity);
}
