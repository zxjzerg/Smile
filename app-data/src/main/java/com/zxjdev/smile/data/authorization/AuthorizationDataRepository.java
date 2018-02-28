package com.zxjdev.smile.data.authorization;

import com.zxjdev.smile.data.authorization.datasource.AuthorizationCloudDataSource;
import com.zxjdev.smile.data.base.BaseDataRepository;
import com.zxjdev.smile.domain.authorization.AuthorizationRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

public class AuthorizationDataRepository extends BaseDataRepository implements AuthorizationRepository {

  private AuthorizationCloudDataSource authorizationCloudDataSource;

  @Inject
  public AuthorizationDataRepository(AuthorizationCloudDataSource authorizationCloudDataSource) {
    this.authorizationCloudDataSource = authorizationCloudDataSource;
  }

  @Override
  public Observable<Void> register(String username, String password) {
    return authorizationCloudDataSource.register(username, password).compose(applyDefaultSchedulerStrategy());
  }

  @Override
  public Observable<Void> login(String username, String password) {
    return authorizationCloudDataSource.login(username, password).compose(applyDefaultSchedulerStrategy());
  }

  @Override
  public Observable<Boolean> checkIsLogined() {
    return authorizationCloudDataSource.checkIsLogined().compose(applyDefaultSchedulerStrategy());
  }

  @Override
  public Observable<Void> logout() {
    return authorizationCloudDataSource.logout().compose(applyDefaultSchedulerStrategy());
  }
}
