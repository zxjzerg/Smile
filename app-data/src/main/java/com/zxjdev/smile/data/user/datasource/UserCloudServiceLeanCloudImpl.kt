package com.zxjdev.smile.data.user.datasource

import com.avos.avoscloud.AVFile
import com.zxjdev.smile.data.user.entity.UserEntity
import javax.inject.Inject

class UserCloudServiceLeanCloudImpl @Inject constructor(private val currentUser: UserEntity) : UserCloudService {

    override fun uploadAvatar(localPath: String): String {
        val file = AVFile.withAbsoluteLocalPath("avatar.jpg", localPath)
        file.save()
        currentUser.avatar = file.url
        currentUser.save()
        return file.url
    }
}
