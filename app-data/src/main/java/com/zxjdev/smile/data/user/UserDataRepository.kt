package com.zxjdev.smile.data.user

import com.zxjdev.smile.data.base.BaseDataRepository
import com.zxjdev.smile.data.user.datasource.UserCloudDataSource
import com.zxjdev.smile.data.user.entity.UserEntity
import com.zxjdev.smile.data.user.entity.UserMapper
import com.zxjdev.smile.domain.user.User
import com.zxjdev.smile.domain.user.UserRepository
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import javax.inject.Inject

class UserDataRepository @Inject constructor(private val userCloudDataSource: UserCloudDataSource,
        private val userMapper: UserMapper) : BaseDataRepository(), UserRepository {

    override fun getCurrentUser(): Observable<User> {
        return Observable.create({ e: ObservableEmitter<UserEntity> ->
            e.onNext(userCloudDataSource.getCurrentUser())
            e.onComplete()
        }).map { userEntity -> userMapper.transform(userEntity) }.compose(applyDefaultSchedulerStrategy())
    }

    override fun uploadAvatar(localPath: String): Observable<String> {
        return Observable.create({ e: ObservableEmitter<String> ->
            e.onNext(userCloudDataSource.uploadAvatar(localPath))
            e.onComplete()
        }).compose(applyDefaultSchedulerStrategy())
    }
}