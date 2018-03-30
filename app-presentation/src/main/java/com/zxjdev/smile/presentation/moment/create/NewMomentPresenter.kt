package com.zxjdev.smile.presentation.moment.create

import com.zxjdev.smile.domain.moment.usecase.AddMoment
import com.zxjdev.smile.presentation.common.util.ui.ErrorMessagePrinter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableCompletableObserver
import javax.inject.Inject

class NewMomentPresenter @Inject internal constructor() : NewMomentContract.Presenter {

    private lateinit var view: NewMomentContract.View
    @Inject lateinit var addMoment: AddMoment
    @Inject lateinit var errorMessagePrinter: ErrorMessagePrinter
    private val compositeDisposable = CompositeDisposable()

    override fun handleAddMoment(content: String) {
        compositeDisposable.add(addMoment.execute(AddMoment.RequestParams(content)).subscribeWith(object : DisposableCompletableObserver() {
            override fun onComplete() {
                view.close()
            }

            override fun onError(e: Throwable) {
                errorMessagePrinter.print(e.message)
            }
        }))
    }

    override fun takeView(view: NewMomentContract.View) {
        this.view = view
    }

    override fun dropView() {
        compositeDisposable.dispose()
    }
}
