package com.zxjdev.smile.presentation.infrastucture.splash

import com.zxjdev.smile.presentation.common.base.BasePresenter
import com.zxjdev.smile.presentation.common.base.BaseView

interface SplashContract {

    interface View : BaseView {

        fun navigateToMain()

        fun showButtons()
    }

    interface Presenter : BasePresenter<View> {

        fun handleAutoLogin()
    }
}
