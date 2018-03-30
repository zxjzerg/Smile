package com.zxjdev.smile.presentation.infrastucture.main

import com.zxjdev.smile.domain.user.User
import com.zxjdev.smile.domain.user.usecase.GetCurrentUser
import com.zxjdev.smile.domain.user.usecase.UploadAvatar
import com.zxjdev.smile.presentation.common.util.ui.ErrorMessagePrinter
import com.zxjdev.smile.presentation.user.UserModel
import com.zxjdev.smile.presentation.user.UserModelMapper
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class MainPresenter @Inject internal constructor() : MainContract.Presenter {

    private var view: MainContract.View? = null
    @Inject lateinit var getCurrentUser: GetCurrentUser
    @Inject lateinit var userModelMapper: UserModelMapper
    @Inject lateinit var uploadAvatar: UploadAvatar
    @Inject lateinit var errorMessagePrinter: ErrorMessagePrinter
    private val compositeDisposable = CompositeDisposable()

    private var currentUser: UserModel? = null

    override fun handleChangeAvatar(picturePath: String) {
        val params = UploadAvatar.RequestParams()
        params.localPath = picturePath
        compositeDisposable.add(uploadAvatar.execute(params).subscribeWith(object : DisposableObserver<String>() {
            override fun onComplete() {
            }

            override fun onNext(t: String) {
                if (currentUser != null) {
                    currentUser?.avatar = t
                    if (view != null) view!!.displayUser(currentUser!!)
                }
            }

            override fun onError(e: Throwable) {
                errorMessagePrinter.print(e.message)
            }
        }))
    }

    override fun takeView(view: MainContract.View) {
        this.view = view
        loadCurrentUser()
    }

    override fun dropView() {
        this.view = null
        compositeDisposable.dispose()
    }

    private fun loadCurrentUser() {
        compositeDisposable.addAll(getCurrentUser.execute().subscribeWith(object : DisposableObserver<User>() {
            override fun onComplete() {
            }

            override fun onNext(t: User) {
                currentUser = userModelMapper.transform(t)
                if (view != null) view!!.displayUser(currentUser!!)
            }

            override fun onError(e: Throwable) {
                errorMessagePrinter.print(e.message)
            }
        }))
    }
}
