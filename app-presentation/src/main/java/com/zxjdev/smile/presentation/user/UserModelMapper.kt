package com.zxjdev.smile.presentation.user

import com.zxjdev.smile.domain.common.base.BaseMapper
import com.zxjdev.smile.domain.user.User

import javax.inject.Inject

class UserModelMapper @Inject
internal constructor() : BaseMapper<UserModel, User>() {

    override fun transform(data: User): UserModel {
        val model = UserModel()
        model.username = data.username
        model.avatar = data.avatar
        return model
    }
}
