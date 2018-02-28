package com.zxjdev.smile.presentation.user.settings

import com.zxjdev.smile.domain.authorization.usecase.Logout
import com.zxjdev.smile.presentation.common.DefaultSubscriber
import com.zxjdev.smile.presentation.common.util.ui.ErrorMessagePrinter

import javax.inject.Inject

class SettingsPresenter @Inject
internal constructor() : SettingsContract.Presenter {

    private var view: SettingsContract.View? = null
    @Inject lateinit var logout: Logout
    @Inject lateinit var errorMessagePrinter: ErrorMessagePrinter

    override fun handleLogout() {
        logout.execute(object : DefaultSubscriber<Void>(errorMessagePrinter) {
            override fun onComplete() {
                view!!.onLogoutSuccess()
            }
        })
    }

    override fun takeView(view: SettingsContract.View) {
        this.view = view
    }

    override fun dropView() {
        this.view = null
        logout.unsubscribe()
    }
}
