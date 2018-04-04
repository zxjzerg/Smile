package com.zxjdev.smile.data.user.datasource

import com.zxjdev.smile.data.user.entity.UserEntity
import javax.inject.Inject

/**
 * 负责云端用户数据的处理
 *
 * @author Andrew
 */
class UserCloudDataSource @Inject constructor(private val userCloudService: UserCloudService,
        private val currentUser: UserEntity) {

    fun getCurrentUser(): UserEntity {
        return currentUser
    }

    fun uploadAvatar(localPath: String): String {
        return userCloudService.uploadAvatar(localPath)
    }
}
