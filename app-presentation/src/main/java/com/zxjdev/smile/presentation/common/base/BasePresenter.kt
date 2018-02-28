package com.zxjdev.smile.presentation.common.base

/**
 * Base class of all presenters
 */
interface BasePresenter<T> {

    fun takeView(view: T)

    fun dropView()
}
