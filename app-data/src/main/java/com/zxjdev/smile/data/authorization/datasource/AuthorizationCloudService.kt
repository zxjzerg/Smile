package com.zxjdev.smile.data.authorization.datasource

interface AuthorizationCloudService {

    fun register(username: String, password: String)

    fun login(username: String, password: String)

    fun checkIsLogined(): Boolean

    fun logout()
}
