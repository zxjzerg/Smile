package com.zxjdev.smile.presentation.authorization.login

import com.zxjdev.smile.domain.authorization.usecase.Login
import com.zxjdev.smile.presentation.common.DefaultSubscriber
import com.zxjdev.smile.presentation.common.util.ui.ErrorMessagePrinter
import timber.log.Timber
import javax.inject.Inject

class LoginPresenter @Inject internal constructor() : LoginContract.Presenter {

    private lateinit var view: LoginContract.View
    @Inject internal lateinit var login: Login
    @Inject internal lateinit var errorMessagePrinter: ErrorMessagePrinter

    override fun handleLogin(username: String, password: String) {
        login.execute(Login.RequestParams(username, password), object : DefaultSubscriber<Void>(errorMessagePrinter) {
            override fun onComplete() {
                view.initUserComponent()
                view.navigateToMain()
            }

            override fun onError() {
                Timber.d("Login failed.")
            }
        })
    }

    override fun takeView(view: LoginContract.View) {
        this.view = view
    }

    override fun dropView() {
        login.unsubscribe()
    }
}
