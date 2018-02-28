package com.zxjdev.smile.data.moment.entity

import com.zxjdev.smile.data.user.entity.UserMapper
import com.zxjdev.smile.domain.common.base.BaseMapper
import com.zxjdev.smile.domain.moment.Moment

import javax.inject.Inject

class MomentMapper @Inject
constructor(private val userMapper: UserMapper) : BaseMapper<Moment, MomentEntity>() {

    override fun transform(data: MomentEntity): Moment {
        val moment = Moment()
        moment.id = data.objectId
        moment.owner = userMapper.transform(data.user)
        moment.content = data.content
        moment.createAt = data.createdAt
        return moment
    }
}
