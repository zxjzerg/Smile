package com.zxjdev.smile.data.user.datasource

import com.zxjdev.smile.data.user.entity.UserEntity
import io.reactivex.Observable
import javax.inject.Inject

/**
 * 负责云端用户数据的处理
 *
 * @author Andrew
 */
class UserCloudDataSource @Inject constructor(private val userCloudService: UserCloudService,
        private val currentUser: UserEntity) {

    fun getUser(id: String?): Observable<UserEntity> {
        return if (id == null) {
            Observable.just(currentUser)
        } else {
            Observable.empty()
        }
    }

    fun uploadAvatar(localPath: String): Observable<String> {
        return userCloudService.uploadAvatar(localPath)
    }
}
