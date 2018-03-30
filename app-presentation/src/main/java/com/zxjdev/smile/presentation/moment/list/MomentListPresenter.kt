package com.zxjdev.smile.presentation.moment.list

import android.arch.lifecycle.LifecycleOwner
import com.zxjdev.smile.domain.moment.Moment
import com.zxjdev.smile.domain.moment.usecase.GetMomentList
import com.zxjdev.smile.presentation.common.util.ui.ErrorMessagePrinter
import com.zxjdev.smile.presentation.moment.MomentModelMapper
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class MomentListPresenter @Inject internal constructor() : MomentListContract.Presenter {

    private lateinit var view: MomentListContract.View
    @Inject lateinit var getMomentList: GetMomentList
    @Inject lateinit var momentModelMapper: MomentModelMapper
    @Inject lateinit var errorMessagePrinter: ErrorMessagePrinter
    @Inject lateinit var viewModel: MomentListViewModel
    @Inject lateinit var lifecycleOwner: LifecycleOwner
    private val compositeDisposable = CompositeDisposable()

    private fun loadMoments() {
        compositeDisposable.add(getMomentList.execute().subscribeWith(object : DisposableObserver<List<Moment>>() {
            override fun onComplete() {
            }

            override fun onNext(t: List<Moment>) {
                viewModel.setMoments(momentModelMapper.transform(t))
            }

            override fun onError(e: Throwable) {
                errorMessagePrinter.print(e.message)
            }
        }))
    }

    override fun refreshMoments() {
        compositeDisposable.add(getMomentList.execute().subscribeWith(object : DisposableObserver<List<Moment>>() {
            override fun onComplete() {
            }

            override fun onNext(t: List<Moment>) {
                view.dismissRefreshingView()
                viewModel.setMoments(momentModelMapper.transform(t))
            }

            override fun onError(e: Throwable) {
                errorMessagePrinter.print(e.message)
            }
        }))
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
        compositeDisposable.dispose()
    }
}
