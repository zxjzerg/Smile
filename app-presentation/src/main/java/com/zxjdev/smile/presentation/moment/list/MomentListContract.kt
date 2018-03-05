package com.zxjdev.smile.presentation.moment.list

import com.zxjdev.smile.presentation.common.base.BasePresenter
import com.zxjdev.smile.presentation.common.base.BaseView
import com.zxjdev.smile.presentation.moment.MomentModel

interface MomentListContract {

    interface View : BaseView {

        fun displayMomentList(momentModels: List<MomentModel>?)

        fun dismissRefreshingView()
    }

    interface Presenter : BasePresenter<View> {

        fun refreshMoments()
    }
}
