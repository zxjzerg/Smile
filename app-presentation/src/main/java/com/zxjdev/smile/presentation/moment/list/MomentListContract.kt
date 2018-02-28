package com.zxjdev.smile.presentation.moment.list

import android.os.Bundle

import com.zxjdev.smile.presentation.common.base.BasePresenter
import com.zxjdev.smile.presentation.common.base.BaseView
import com.zxjdev.smile.presentation.moment.MomentModel

interface MomentListContract {

    interface View : BaseView {

        fun displayMomentList(momentModels: List<MomentModel>)

        fun dismissRefreshingView()
    }

    interface Presenter : BasePresenter<View> {

        fun loadMoments()

        fun refreshMoments()

        fun saveInstanceState(outState: Bundle?)

        fun loadSavedInstanceState(savedInstanceState: Bundle?)
    }
}
