package com.zxjdev.smile.presentation.infrastucture.splash

import android.os.Handler
import com.zxjdev.smile.domain.authorization.usecase.AutoLogin
import com.zxjdev.smile.presentation.common.util.ui.ErrorMessagePrinter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class SplashPresenter @Inject internal constructor() : SplashContract.Presenter {

    @Inject lateinit var autoLogin: AutoLogin
    private lateinit var view: SplashContract.View
    @Inject lateinit var errorMessagePrinter: ErrorMessagePrinter
    private val handler: Handler = Handler()
    private val compositeDisposable = CompositeDisposable()

    private val mNavigateToMainTask = Runnable { view.navigateToMain() }

    override fun handleAutoLogin() {
        compositeDisposable.add(autoLogin.execute().subscribeWith(object : DisposableObserver<Boolean>() {
            override fun onComplete() {
            }

            override fun onNext(t: Boolean) {
                if (t) {
                    // 自动登录
                    handler.postDelayed(mNavigateToMainTask, 500)
                } else {
                    // 显示登录和注册按钮
                    view.showButtons()
                }
            }

            override fun onError(e: Throwable) {
                errorMessagePrinter.print(e.message)
            }
        }))
    }

    override fun takeView(view: SplashContract.View) {
        this.view = view
    }

    override fun dropView() {
        compositeDisposable.dispose()
        handler.removeCallbacks(mNavigateToMainTask)
    }
}
