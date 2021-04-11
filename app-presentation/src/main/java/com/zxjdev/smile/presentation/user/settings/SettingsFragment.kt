package com.zxjdev.smile.presentation.user.settings

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zxjdev.smile.R
import com.zxjdev.smile.presentation.common.SmileApplication
import com.zxjdev.smile.presentation.common.base.fragment.BaseFragment
import com.zxjdev.smile.presentation.infrastucture.splash.SplashActivity
import kotlinx.android.synthetic.main.fragment_settings.*
import javax.inject.Inject

class SettingsFragment : BaseFragment(), SettingsContract.View {

    @Inject internal lateinit var settingsPresenter: SettingsPresenter

    init {
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_logout.setOnClickListener { settingsPresenter.handleLogout() }
        settingsPresenter.takeView(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        settingsPresenter.dropView()
    }

    override fun onLogoutSuccess() {
        (activity?.application as SmileApplication).releaseUserComponent()

        val intent = Intent(activity, SplashActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    companion object {

        val TAG: String = SettingsFragment::class.java.simpleName
    }
}
