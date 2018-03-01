package com.zxjdev.smile.presentation.infrastucture.main

import com.zxjdev.smile.domain.user.User
import com.zxjdev.smile.domain.user.usecase.GetCurrentUser
import com.zxjdev.smile.domain.user.usecase.UploadAvatar
import com.zxjdev.smile.presentation.common.DefaultSubscriber
import com.zxjdev.smile.presentation.common.util.ui.ErrorMessagePrinter
import com.zxjdev.smile.presentation.user.UserModel
import com.zxjdev.smile.presentation.user.UserModelMapper

import javax.inject.Inject

class MainPresenter @Inject internal constructor() : MainContract.Presenter {

    private var view: MainContract.View? = null
    @Inject lateinit var getCurrentUser: GetCurrentUser
    @Inject lateinit var userModelMapper: UserModelMapper
    @Inject lateinit var uploadAvatar: UploadAvatar
    @Inject lateinit var errorMessagePrinter: ErrorMessagePrinter

    private var currentUser: UserModel? = null

    override fun handleChangeAvatar(picturePath: String) {
        val params = UploadAvatar.RequestParams()
        params.localPath = picturePath
        uploadAvatar.execute(params, object : DefaultSubscriber<String>(errorMessagePrinter) {
            override fun onNext(data: String) {
                if (currentUser != null) {
                    currentUser?.avatar = data
                    if (view != null) view!!.displayUser(currentUser!!)
                }
            }
        })
    }

    override fun takeView(view: MainContract.View) {
        this.view = view
        loadCurrentUser()
    }

    override fun dropView() {
        this.view = null
        getCurrentUser.unsubscribe()
        uploadAvatar.unsubscribe()
    }

    private fun loadCurrentUser() {
        getCurrentUser.execute(object : DefaultSubscriber<User>(errorMessagePrinter) {
            override fun onNext(data: User) {
                currentUser = userModelMapper.transform(data)
                if (view != null) view!!.displayUser(currentUser!!)
            }
        })
    }
}
