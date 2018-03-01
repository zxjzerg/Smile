package com.zxjdev.smile.presentation.common

import android.util.Log
import com.avos.avoscloud.AVException
import com.zxjdev.smile.presentation.common.util.ui.ErrorMessagePrinter

import io.reactivex.observers.DisposableObserver
import timber.log.Timber

open class DefaultSubscriber<T>(errorMessagePrinter: ErrorMessagePrinter) : DisposableObserver<T>() {

    private val errorMessagePrinter: ErrorMessagePrinter? = errorMessagePrinter


    override fun onComplete() {
    }

    override fun onError(e: Throwable) {
        Timber.e(e.message)
        processError(e)
        this.onError()
    }

    open fun onError() {
    }

    override fun onNext(data: T) {
    }

    private fun processError(e: Throwable) {
        Log.e("Subscriber", "", e)
        if (e is AVException) {
            processNetworkError(e)
        } else {
            printErrorMessage(e.message)
        }
    }

    private fun processNetworkError(e: AVException) {
        val code = e.code
        var message = e.message
        when (code) {
            AVException.USERNAME_TAKEN -> {
                message = "用户名已经被使用"
                printErrorMessage(message)
            }
            else -> printErrorMessage(message)
        }
    }

    private fun printErrorMessage(message: String?) {
        errorMessagePrinter?.print(message)
    }
}
