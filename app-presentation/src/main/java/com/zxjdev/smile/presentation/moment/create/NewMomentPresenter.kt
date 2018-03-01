package com.zxjdev.smile.presentation.moment.create

import com.zxjdev.smile.domain.moment.usecase.AddMoment
import com.zxjdev.smile.presentation.common.DefaultSubscriber
import com.zxjdev.smile.presentation.common.util.ui.ErrorMessagePrinter

import javax.inject.Inject

class NewMomentPresenter @Inject internal constructor() : NewMomentContract.Presenter {

    private lateinit var view: NewMomentContract.View
    @Inject lateinit var addMoment: AddMoment
    @Inject lateinit var errorMessagePrinter: ErrorMessagePrinter

    override fun handleAddMoment(content: String) {
        addMoment.execute(AddMoment.RequestParams(content), object : DefaultSubscriber<Void>(errorMessagePrinter) {
            override fun onComplete() {
                super.onComplete()
                view.close()
            }
        })
    }

    override fun takeView(view: NewMomentContract.View) {
        this.view = view
    }

    override fun dropView() {
        addMoment.unsubscribe()
    }
}
