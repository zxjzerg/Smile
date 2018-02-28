package com.zxjdev.smile.data.user.entity

import com.avos.avoscloud.AVUser

class UserEntity : AVUser() {

    var nickName: String?
        get() = this.getString("nickName")
        set(name) = this.put("nickName", name)

    var avatar: String?
        get() = this.getString("avatar")
        set(url) = this.put("avatar", url)
}