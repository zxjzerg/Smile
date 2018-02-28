package com.zxjdev.smile.presentation.authorization.register

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.widget.EditText
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.zxjdev.smile.R
import com.zxjdev.smile.presentation.common.SmileApplication
import com.zxjdev.smile.presentation.common.base.activity.BaseActivity
import com.zxjdev.smile.presentation.infrastucture.main.MainActivity
import javax.inject.Inject

class RegisterActivity : BaseActivity(), RegisterContract.View {

    @BindView(R.id.et_username) internal lateinit var etUsername: EditText
    @BindView(R.id.et_password) internal lateinit var etPassword: EditText
    @BindView(R.id.toolbar) internal lateinit var toolbar: Toolbar

    @Inject internal lateinit var presenter: RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_register)
        ButterKnife.bind(this)
        initUi()

        presenter!!.takeView(this)
    }

    override fun onDestroy() {
        presenter!!.dropView()
        super.onDestroy()
    }

    @OnClick(R.id.btn_register)
    internal fun handleRegisterClick() {
        presenter!!.handleRegister(etUsername!!.text.toString(), etPassword!!.text.toString())
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
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = null
    }
}
