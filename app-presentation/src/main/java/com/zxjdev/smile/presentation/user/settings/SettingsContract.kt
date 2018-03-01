package com.zxjdev.smile.presentation.user.settings

import com.zxjdev.smile.presentation.common.base.BasePresenter
import com.zxjdev.smile.presentation.common.base.BaseView

interface SettingsContract {

    interface View : BaseView {

        fun onLogoutSuccess()
    }

    interface Presenter : BasePresenter<View> {

        fun handleLogout()
    }
}
