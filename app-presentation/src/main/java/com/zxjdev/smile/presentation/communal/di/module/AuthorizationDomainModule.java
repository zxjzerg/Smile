package com.zxjdev.smile.presentation.communal.di.module;

import com.zxjdev.smile.data.authorization.AuthorizationDataModule;
import com.zxjdev.smile.domain.authorization.AuthorizationRepository;
import com.zxjdev.smile.domain.authorization.usecase.AutoLogin;
import com.zxjdev.smile.domain.authorization.usecase.Login;
import com.zxjdev.smile.domain.authorization.usecase.Logout;
import com.zxjdev.smile.domain.authorization.usecase.Register;
import com.zxjdev.smile.domain.communal.base.SchedulerFactory;

import dagger.Module;
import dagger.Provides;

@Module(includes = AuthorizationDataModule.class)
public class AuthorizationDomainModule {

  @Provides
  AutoLogin provideAutoLogin(SchedulerFactory schedulerFactory, AuthorizationRepository repository) {
    return new AutoLogin(schedulerFactory, repository);
  }

  @Provides
  Login provideLogin(SchedulerFactory schedulerFactory, AuthorizationRepository repository) {
    return new Login(schedulerFactory, repository);
  }

  @Provides
  Logout provideLogout(SchedulerFactory schedulerFactory, AuthorizationRepository repository) {
    return new Logout(schedulerFactory, repository);
  }

  @Provides
  Register provideRegister(SchedulerFactory schedulerFactory, AuthorizationRepository repository) {
    return new Register(schedulerFactory, repository);
  }
}
