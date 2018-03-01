package com.zxjdev.smile.presentation.infrastucture.splash

import android.os.Handler

import com.zxjdev.smile.domain.authorization.usecase.AutoLogin
import com.zxjdev.smile.presentation.common.DefaultSubscriber
import com.zxjdev.smile.presentation.common.util.ui.ErrorMessagePrinter

import javax.inject.Inject

class SplashPresenter @Inject internal constructor() : SplashContract.Presenter {

    @Inject lateinit var autoLogin: AutoLogin
    private lateinit var view: SplashContract.View
    @Inject lateinit var errorMessagePrinter: ErrorMessagePrinter
    private val handler: Handler = Handler()

    private val mNavigateToMainTask = Runnable { view.navigateToMain() }

    override fun handleAutoLogin() {
        autoLogin.execute(object : DefaultSubscriber<Boolean>(errorMessagePrinter) {
            override fun onNext(data: Boolean) {
                if (data) {
                    // 自动登录
                    handler.postDelayed(mNavigateToMainTask, 500)
                } else {
                    // 显示登录和注册按钮
                    view.showButtons()
                }
            }
        })
    }

    override fun takeView(view: SplashContract.View) {
        this.view = view
    }

    override fun dropView() {
        autoLogin.unsubscribe()
        handler.removeCallbacks(mNavigateToMainTask)
    }
}
