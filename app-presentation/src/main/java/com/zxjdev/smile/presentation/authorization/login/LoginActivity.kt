package com.zxjdev.smile.presentation.authorization.login

import android.content.Intent
import android.os.Bundle
import com.zxjdev.smile.R
import com.zxjdev.smile.presentation.common.SmileApplication
import com.zxjdev.smile.presentation.common.base.activity.BaseActivity
import com.zxjdev.smile.presentation.infrastucture.main.MainActivity
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : BaseActivity(), LoginContract.View {

    @Inject internal lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initUi()

        presenter.takeView(this)
    }

    override fun onDestroy() {
        presenter.dropView()
        super.onDestroy()
    }

    override fun navigateToMain() {
        val intent = Intent(context, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    override fun initUserComponent() {
        (application as SmileApplication).initUserComponent()
    }

    private fun initUi() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = null

        btn_login.setOnClickListener { presenter.handleLogin(et_username.text.toString(), et_password.text.toString()) }
    }
}
