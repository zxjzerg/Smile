package com.zxjdev.smile.presentation.authorization.login

import com.zxjdev.smile.presentation.common.base.BasePresenter
import com.zxjdev.smile.presentation.common.base.BaseView

interface LoginContract {

    interface View : BaseView {

        fun navigateToMain()

        fun initUserComponent()
    }

    interface Presenter : BasePresenter<View> {

        fun handleLogin(username: String, password: String)
    }
}
