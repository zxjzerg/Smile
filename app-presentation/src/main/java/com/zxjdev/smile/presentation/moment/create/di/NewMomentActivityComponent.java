package com.zxjdev.smile.presentation.moment.create.di;

import com.zxjdev.smile.presentation.moment.create.NewMomentActivity;

import dagger.Subcomponent;

@Subcomponent(modules = {
  NewMomentActivityModule.class
})
public interface NewMomentActivityComponent {

  void inject(NewMomentActivity activity);
}
