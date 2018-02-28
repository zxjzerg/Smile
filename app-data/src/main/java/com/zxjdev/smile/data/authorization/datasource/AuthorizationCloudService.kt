package com.zxjdev.smile.data.authorization.datasource

import io.reactivex.Observable

interface AuthorizationCloudService {

    fun register(username: String, password: String): Observable<Void>

    fun login(username: String, password: String): Observable<Void>

    fun checkIsLogined(): Observable<Boolean>

    fun logout(): Observable<Void>
}
