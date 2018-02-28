package com.zxjdev.smile.presentation.common.di.module;

import com.zxjdev.smile.data.authorization.di.AuthorizationDataModule;
import com.zxjdev.smile.domain.authorization.AuthorizationRepository;
import com.zxjdev.smile.domain.authorization.usecase.AutoLogin;
import com.zxjdev.smile.domain.authorization.usecase.Login;
import com.zxjdev.smile.domain.authorization.usecase.Logout;
import com.zxjdev.smile.domain.authorization.usecase.Register;

import dagger.Module;
import dagger.Provides;

@Module(includes = AuthorizationDataModule.class)
public class AuthorizationDomainModule {

  @Provides
  AutoLogin provideAutoLogin(AuthorizationRepository repository) {
    return new AutoLogin(repository);
  }

  @Provides
  Login provideLogin(AuthorizationRepository repository) {
    return new Login(repository);
  }

  @Provides
  Logout provideLogout(AuthorizationRepository repository) {
    return new Logout(repository);
  }

  @Provides
  Register provideRegister(AuthorizationRepository repository) {
    return new Register(repository);
  }
}
