package com.zxjdev.smile.data.moment.entity

import com.avos.avoscloud.AVClassName
import com.avos.avoscloud.AVObject
import com.zxjdev.smile.data.user.entity.UserEntity

@AVClassName("Moment")
class MomentEntity : AVObject() {

    var content: String?
        get() = getString("content")
        set(content) = put("content", content)

    val user: UserEntity
        get() = getAVUser("user", UserEntity::class.java)

    fun setOwner(user: UserEntity) {
        put("user", user)
    }
}
