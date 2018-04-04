package com.zxjdev.smile.data.user.datasource

interface UserCloudService {

    fun uploadAvatar(localPath: String): String
}
