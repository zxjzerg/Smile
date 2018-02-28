package com.zxjdev.smile.presentation.common.di.component;

import android.app.Application;

import com.zxjdev.smile.presentation.common.SmileApplication;
import com.zxjdev.smile.presentation.common.di.module.ActivityBindingModule;
import com.zxjdev.smile.presentation.common.di.module.ApplicationModule;
import com.zxjdev.smile.presentation.common.di.module.AuthorizationDomainModule;
import com.zxjdev.smile.presentation.common.di.module.MomentDomainModule;
import com.zxjdev.smile.presentation.common.di.module.UserDomainModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
  AndroidSupportInjectionModule.class,
  ApplicationModule.class,
  AuthorizationDomainModule.class,
  MomentDomainModule.class,
  UserDomainModule.class,
  ActivityBindingModule.class
})
public interface ApplicationComponent extends AndroidInjector<SmileApplication> {

  @Component.Builder
  interface Builder {

    @BindsInstance
    ApplicationComponent.Builder application(Application application);

    ApplicationComponent build();
  }
}
