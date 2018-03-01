package com.zxjdev.smile.data.user.entity

import com.zxjdev.smile.domain.common.base.BaseMapper
import com.zxjdev.smile.domain.user.User

import javax.inject.Inject

class UserMapper @Inject constructor() : BaseMapper<User, UserEntity>() {

    override fun transform(userEntity: UserEntity): User {
        val user = User()
        user.username = userEntity.username
        user.nickname = userEntity.nickName
        user.avatar = userEntity.avatar
        return user
    }
}