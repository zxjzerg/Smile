package com.zxjdev.smile.data.authorization.datasource

import javax.inject.Inject

class AuthorizationCloudDataSource @Inject constructor(
        private val authorizationCloudService: AuthorizationCloudService) {

    fun register(username: String, password: String) {
        authorizationCloudService.register(username, password)
    }

    fun login(username: String, password: String) {
        authorizationCloudService.login(username, password)
    }

    fun checkIsLogined(): Boolean {
        return authorizationCloudService.checkIsLogined()
    }

    fun logout() {
        authorizationCloudService.logout()
    }
}
