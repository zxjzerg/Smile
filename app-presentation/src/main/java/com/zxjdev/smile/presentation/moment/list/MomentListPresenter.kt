package com.zxjdev.smile.presentation.moment.list

import android.os.Bundle
import com.zxjdev.smile.domain.moment.Moment
import com.zxjdev.smile.domain.moment.usecase.GetMomentList
import com.zxjdev.smile.presentation.common.DefaultSubscriber
import com.zxjdev.smile.presentation.common.util.ui.ErrorMessagePrinter
import com.zxjdev.smile.presentation.moment.MomentModel
import com.zxjdev.smile.presentation.moment.MomentModelMapper
import java.util.*
import javax.inject.Inject

class MomentListPresenter @Inject internal constructor() : MomentListContract.Presenter {

    private lateinit var view: MomentListContract.View
    @Inject lateinit var getMomentList: GetMomentList
    @Inject lateinit var momentModelMapper: MomentModelMapper
    @Inject lateinit var errorMessagePrinter: ErrorMessagePrinter

    private var moments = ArrayList<MomentModel>()

    override fun loadMoments() {
        getMomentList.execute(object : DefaultSubscriber<List<Moment>>(errorMessagePrinter) {
            override fun onNext(data: List<Moment>) {
                moments.clear()
                moments.addAll(momentModelMapper.transform(data))
                view.displayMomentList(moments)
            }
        })
    }

    override fun refreshMoments() {
        getMomentList.execute(object : DefaultSubscriber<List<Moment>>(errorMessagePrinter) {
            override fun onNext(data: List<Moment>) {
                moments.clear()
                moments.addAll(momentModelMapper!!.transform(data))
                view.displayMomentList(moments)
                view.dismissRefreshingView()
            }
        })
    }

    override fun saveInstanceState(outState: Bundle?) {
        outState?.putParcelableArrayList(EXTRA_MOMENT_LIST, moments)
    }

    override fun loadSavedInstanceState(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) return

        val moments = savedInstanceState.getParcelableArrayList<MomentModel>(EXTRA_MOMENT_LIST)
        if (moments != null) {
            this.moments = moments
            view.displayMomentList(moments)
        }
    }

    override fun takeView(view: MomentListContract.View) {
        this.view = view
    }

    override fun dropView() {
        getMomentList.unsubscribe()
    }

    companion object {

        private const val EXTRA_MOMENT_LIST = "extra_moment_list"
    }
}
