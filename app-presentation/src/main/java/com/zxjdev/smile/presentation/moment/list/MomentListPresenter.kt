package com.zxjdev.smile.presentation.moment.list

import android.arch.lifecycle.LifecycleOwner
import com.zxjdev.smile.domain.moment.Moment
import com.zxjdev.smile.domain.moment.usecase.GetMomentList
import com.zxjdev.smile.presentation.common.DefaultSubscriber
import com.zxjdev.smile.presentation.common.util.ui.ErrorMessagePrinter
import com.zxjdev.smile.presentation.moment.MomentModelMapper
import javax.inject.Inject

class MomentListPresenter @Inject internal constructor() : MomentListContract.Presenter {

    private lateinit var view: MomentListContract.View
    @Inject lateinit var getMomentList: GetMomentList
    @Inject lateinit var momentModelMapper: MomentModelMapper
    @Inject lateinit var errorMessagePrinter: ErrorMessagePrinter
    @Inject lateinit var viewModel: MomentListViewModel
    @Inject lateinit var lifecycleOwner: LifecycleOwner

    private fun loadMoments() {
        getMomentList.execute(object : DefaultSubscriber<List<Moment>>(errorMessagePrinter) {
            override fun onNext(data: List<Moment>) {
                viewModel.setMoments(momentModelMapper.transform(data))
            }
        })
    }

    override fun refreshMoments() {
        getMomentList.execute(object : DefaultSubscriber<List<Moment>>(errorMessagePrinter) {
            override fun onNext(data: List<Moment>) {
                view.dismissRefreshingView()
                viewModel.setMoments(momentModelMapper.transform(data))
            }
        })
    }

    override fun takeView(view: MomentListContract.View) {
        this.view = view
        if (viewModel.getMoments().value == null) {
            loadMoments()
        }
        viewModel.getMoments().observe(lifecycleOwner, android.arch.lifecycle.Observer { models ->
            view.displayMomentList(models)
        })
    }

    override fun dropView() {
        getMomentList.unsubscribe()
    }
}
