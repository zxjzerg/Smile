package com.zxjdev.smile.presentation.authorization.register

import com.zxjdev.smile.presentation.common.base.BasePresenter
import com.zxjdev.smile.presentation.common.base.BaseView

interface RegisterContract {

    interface View : BaseView {

        fun navigateToMain()

        fun initUserComponent()
    }

    interface Presenter : BasePresenter<View> {

        fun handleRegister(username: String, password: String)
    }
}