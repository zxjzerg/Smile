package com.zxjdev.smile.data.user

import com.zxjdev.smile.data.base.BaseDataRepository
import com.zxjdev.smile.data.user.datasource.UserCloudDataSource
import com.zxjdev.smile.data.user.entity.UserMapper
import com.zxjdev.smile.domain.user.User
import com.zxjdev.smile.domain.user.UserRepository

import javax.inject.Inject

import io.reactivex.Observable

class UserDataRepository @Inject
constructor(private val userCloudDataSource: UserCloudDataSource, private val userMapper: UserMapper) : BaseDataRepository(), UserRepository {

    override fun getUser(id: String): Observable<User> {
        return userCloudDataSource.getUser(id)
                .map { userEntity -> userMapper.transform(userEntity) }
                .compose(applyDefaultSchedulerStrategy())
    }

    override fun getCurrentUser(): Observable<User> {
        return userCloudDataSource.getUser(null)
                .map { userEntity -> userMapper.transform(userEntity) }
                .compose(applyDefaultSchedulerStrategy())
    }

    override fun uploadAvatar(localPath: String): Observable<String> {
        return userCloudDataSource.uploadAvatar(localPath).compose(applyDefaultSchedulerStrategy())
    }
}