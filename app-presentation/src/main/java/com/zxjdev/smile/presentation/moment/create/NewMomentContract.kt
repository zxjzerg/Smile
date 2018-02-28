package com.zxjdev.smile.presentation.moment.create

import com.zxjdev.smile.presentation.common.base.BasePresenter
import com.zxjdev.smile.presentation.common.base.BaseView

interface NewMomentContract {

    interface View : BaseView {

        fun close()
    }

    interface Presenter : BasePresenter<View> {

        fun handleAddMoment(content: String)
    }
}
