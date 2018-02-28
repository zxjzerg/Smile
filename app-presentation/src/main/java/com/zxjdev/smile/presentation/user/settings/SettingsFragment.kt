package com.zxjdev.smile.presentation.user.settings

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.zxjdev.smile.R
import com.zxjdev.smile.presentation.common.SmileApplication
import com.zxjdev.smile.presentation.common.base.fragment.BaseFragment
import com.zxjdev.smile.presentation.infrastucture.splash.SplashActivity
import javax.inject.Inject

class SettingsFragment : BaseFragment(), SettingsContract.View {

    @BindView(R.id.btn_logout) internal lateinit var btnLogout: Button

    @Inject internal lateinit var settingsPresenter: SettingsPresenter

    init {
        retainInstance = true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_settings, container, false)
        ButterKnife.bind(this, view)
        settingsPresenter!!.takeView(this)
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        settingsPresenter!!.dropView()
    }

    @OnClick(R.id.btn_logout)
    fun logoutClick() {
        settingsPresenter!!.handleLogout()
    }

    override fun onLogoutSuccess() {
        (activity.application as SmileApplication).releaseUserComponent()

        val intent = Intent(activity, SplashActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    companion object {

        val TAG = SettingsFragment::class.java.simpleName
    }
}
