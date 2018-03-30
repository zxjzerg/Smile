package com.zxjdev.smile.data.authorization.datasource

import io.reactivex.Completable
import io.reactivex.Observable

interface AuthorizationCloudService {

    fun register(username: String, password: String): Completable

    fun login(username: String, password: String): Completable

    fun checkIsLogined(): Observable<Boolean>

    fun logout(): Completable
}
