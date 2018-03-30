package com.zxjdev.smile.data.authorization.datasource

import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class AuthorizationCloudDataSource @Inject constructor(private val authorizationCloudService: AuthorizationCloudService) {

    fun register(username: String, password: String): Completable {
        return authorizationCloudService.register(username, password)
    }

    fun login(username: String, password: String): Completable {
        return authorizationCloudService.login(username, password)
    }

    fun checkIsLogined(): Observable<Boolean> {
        return authorizationCloudService.checkIsLogined()
    }

    fun logout(): Completable {
        return authorizationCloudService.logout()
    }
}
