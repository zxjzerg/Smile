package com.zxjdev.smile.presentation.moment

import com.zxjdev.smile.domain.common.base.BaseMapper
import com.zxjdev.smile.domain.moment.Moment
import com.zxjdev.smile.presentation.user.UserModelMapper

import javax.inject.Inject

class MomentModelMapper @Inject
constructor() : BaseMapper<MomentModel, Moment>() {

    @Inject lateinit var userModelMapper: UserModelMapper

    override fun transform(data: Moment): MomentModel {
        val model = MomentModel()
        model.owner = userModelMapper!!.transform(data.owner)
        model.content = data.content
        model.createAt = data.createAt
        return model
    }
}
