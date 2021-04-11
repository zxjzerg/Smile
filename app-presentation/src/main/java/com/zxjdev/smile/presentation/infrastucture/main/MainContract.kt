package com.zxjdev.smile.presentation.infrastucture.main

import com.zxjdev.smile.presentation.common.base.BasePresenter
import com.zxjdev.smile.presentation.common.base.BaseView
import com.zxjdev.smile.presentation.user.UserModel

interface MainContract {

    interface View : BaseView {

        fun displayUser(user: UserModel)
    }

    interface Presenter : BasePresenter<View> {

        fun handleChangeAvatar(picturePath: String?)
    }
}
