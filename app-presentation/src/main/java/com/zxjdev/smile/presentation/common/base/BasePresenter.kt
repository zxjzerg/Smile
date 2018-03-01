package com.zxjdev.smile.presentation.common.base

/**
 * Base class of all presenters
 */
interface BasePresenter<in T> {

    fun takeView(view: T)

    fun dropView()
}
