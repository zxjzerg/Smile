package com.zxjdev.smile.data.base

import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Base class of all the data repositories
 */
abstract class BaseDataRepository {

    protected fun <T> applyDefaultSchedulerStrategy(): ObservableTransformer<T, T> {
        return ObservableTransformer { upstream ->
            upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        }
    }
}
