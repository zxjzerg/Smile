package com.zxjdev.smile.data.authorization.datasource

import com.avos.avoscloud.AVUser
import com.zxjdev.smile.data.user.entity.UserEntity
import javax.inject.Inject

class AuthorizationCloudServiceLeanCloudImpl @Inject constructor() : AuthorizationCloudService {

    override fun register(username: String, password: String) {
        val user = AVUser()
        user.username = username
        user.setPassword(password)
        user.signUp()
    }

    override fun login(username: String, password: String) {
        AVUser.logIn(username, password, UserEntity::class.java)
    }

    override fun checkIsLogined(): Boolean {
        return AVUser.getCurrentUser() != null
    }

    override fun logout() {
        AVUser.logOut()
    }
}
