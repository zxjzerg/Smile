package com.zxjdev.smile.presentation.authorization.register

import com.zxjdev.smile.domain.authorization.usecase.Register
import com.zxjdev.smile.presentation.common.DefaultSubscriber
import com.zxjdev.smile.presentation.common.util.ui.ErrorMessagePrinter

import javax.inject.Inject

class RegisterPresenter @Inject
internal constructor() : RegisterContract.Presenter {

    private var view: RegisterContract.View? = null
    @Inject
    lateinit var register: Register
    @Inject
    lateinit var errorMessagePrinter: ErrorMessagePrinter

    override fun handleRegister(username: String, password: String) {
        register!!.execute(Register.RequestParams(username, password), object : DefaultSubscriber<Void>(errorMessagePrinter) {
            override fun onComplete() {
                view!!.initUserComponent()
                view!!.navigateToMain()
            }
        })
    }

    override fun takeView(view: RegisterContract.View) {
        this.view = view
    }

    override fun dropView() {
        this.view = null
    }
}
