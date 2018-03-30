package com.zxjdev.smile.presentation.user.settings

import com.zxjdev.smile.domain.authorization.usecase.Logout
import com.zxjdev.smile.presentation.common.util.ui.ErrorMessagePrinter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableCompletableObserver
import javax.inject.Inject

class SettingsPresenter @Inject internal constructor() : SettingsContract.Presenter {

    private lateinit var view: SettingsContract.View
    @Inject lateinit var logout: Logout
    @Inject lateinit var errorMessagePrinter: ErrorMessagePrinter
    private val compositeDisposable = CompositeDisposable()

    override fun handleLogout() {
        compositeDisposable.add(logout.execute(null).subscribeWith(object : DisposableCompletableObserver() {
            override fun onComplete() {
                view.onLogoutSuccess()
            }

            override fun onError(e: Throwable) {
                errorMessagePrinter.print(e.message)
            }
        }))
    }

    override fun takeView(view: SettingsContract.View) {
        this.view = view
    }

    override fun dropView() {
        compositeDisposable.dispose()
    }
}
