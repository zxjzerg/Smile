package com.zxjdev.smile.presentation.authorization.login

import com.zxjdev.smile.domain.authorization.usecase.Login
import com.zxjdev.smile.presentation.common.util.ui.ErrorMessagePrinter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableCompletableObserver
import timber.log.Timber
import javax.inject.Inject

class LoginPresenter @Inject constructor() : LoginContract.Presenter {

    private lateinit var view: LoginContract.View
    @Inject internal lateinit var login: Login
    @Inject internal lateinit var errorMessagePrinter: ErrorMessagePrinter
    private var completableObserver: CompositeDisposable = CompositeDisposable()

    override fun handleLogin(username: String, password: String) {
        completableObserver.add(login.execute(Login.RequestParams(username,
                password)).subscribeWith(object : DisposableCompletableObserver() {
            override fun onComplete() {
                view.initUserComponent()
                view.navigateToMain()
            }

            override fun onError(e: Throwable) {
                Timber.e("Login failed.", e)
            }
        }))
    }

    override fun takeView(view: LoginContract.View) {
        this.view = view
    }

    override fun dropView() {
        completableObserver.dispose()
    }
}
