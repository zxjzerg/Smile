package com.zxjdev.smile.presentation.authorization.register

import com.zxjdev.smile.domain.authorization.usecase.Register
import com.zxjdev.smile.presentation.common.util.ui.ErrorMessagePrinter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableCompletableObserver
import javax.inject.Inject

class RegisterPresenter @Inject internal constructor() : RegisterContract.Presenter {

    private lateinit var view: RegisterContract.View
    @Inject lateinit var register: Register
    @Inject lateinit var errorMessagePrinter: ErrorMessagePrinter
    private val compositeDisposable = CompositeDisposable()

    override fun handleRegister(username: String, password: String) {
        compositeDisposable.add(register.execute(Register.RequestParams(username,
                password)).subscribeWith(object : DisposableCompletableObserver() {
            override fun onComplete() {
                view.initUserComponent()
                view.navigateToMain()
            }

            override fun onError(e: Throwable) {
                errorMessagePrinter.print(e.message)
            }
        }))
    }

    override fun takeView(view: RegisterContract.View) {
        this.view = view
    }

    override fun dropView() {
        compositeDisposable.dispose()
    }
}
