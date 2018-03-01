package com.zxjdev.smile.data.authorization.datasource

import io.reactivex.Observable
import javax.inject.Inject

class AuthorizationCloudDataSource @Inject constructor(private val authorizationCloudService: AuthorizationCloudService) {

    fun register(username: String, password: String): Observable<Void> {
        return authorizationCloudService.register(username, password)
    }

    fun login(username: String, password: String): Observable<Void> {
        return authorizationCloudService.login(username, password)
    }

    fun checkIsLogined(): Observable<Boolean> {
        return authorizationCloudService.checkIsLogined()
    }

    fun logout(): Observable<Void> {
        return authorizationCloudService.logout()
    }
}
