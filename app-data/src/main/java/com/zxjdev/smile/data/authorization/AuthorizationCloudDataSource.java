package com.zxjdev.smile.data.authorization;

import javax.inject.Inject;

import rx.Observable;

public class AuthorizationCloudDataSource {

  private AuthorizationCloudService authorizationCloudService;

  @Inject
  public AuthorizationCloudDataSource(AuthorizationCloudService authorizationCloudService) {
    this.authorizationCloudService = authorizationCloudService;
  }

  public Observable<Void> register(String username, String password) {
    return authorizationCloudService.register(username, password);
  }

  public rx.Observable<Void> login(String username, String password) {
    return authorizationCloudService.login(username, password);
  }

  public Observable<Boolean> checkIsLogined() {
    return authorizationCloudService.checkIsLogined();
  }

  public Observable<Void> logout() {
    return authorizationCloudService.logout();
  }
}
