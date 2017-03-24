package com.zxjdev.smile.data.authorization;

import com.zxjdev.smile.domain.authorization.AuthorizationRepository;

import javax.inject.Inject;

import rx.Observable;

public class AuthorizationDataRepository implements AuthorizationRepository {

  private AuthorizationCloudDataSource authorizationCloudDataSource;

  @Inject
  public AuthorizationDataRepository(AuthorizationCloudDataSource authorizationCloudDataSource) {
    this.authorizationCloudDataSource = authorizationCloudDataSource;
  }

  @Override
  public Observable<Void> register(String username, String password) {
    return authorizationCloudDataSource.register(username, password);
  }

  @Override
  public Observable<Void> login(String username, String password) {
    return authorizationCloudDataSource.login(username, password);
  }

  @Override
  public Observable<Boolean> checkIsLogined() {
    return authorizationCloudDataSource.checkIsLogined();
  }

  @Override
  public Observable<Void> logout() {
    return authorizationCloudDataSource.logout();
  }
}
