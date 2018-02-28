package com.zxjdev.smile.presentation.common

import android.content.Context
import com.avos.avoscloud.AVOSCloud
import com.avos.avoscloud.AVObject
import com.avos.avoscloud.AVUser
import com.facebook.stetho.Stetho
import com.zxjdev.smile.BuildConfig
import com.zxjdev.smile.data.moment.entity.MomentEntity
import com.zxjdev.smile.data.user.entity.UserEntity
import com.zxjdev.smile.presentation.common.di.component.DaggerApplicationComponent

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber

class SmileApplication : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()

        initThirdPartySDK()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.builder().application(this).build()
    }

    private fun initThirdPartySDK() {
        initLeanCloud()

        initTimber()

        initStetho()
    }

    private fun initLeanCloud() {
        // 使运行时获得用户对象都未UserEntity, 必须在initialize之前调用
        AVUser.alwaysUseSubUserClass(UserEntity::class.java)

        // 注册子类化的类
        AVObject.registerSubclass(MomentEntity::class.java)

        // 初始化LeanCloud
        AVOSCloud.initialize(this, BuildConfig.LEANCOULD_APP_ID, BuildConfig.LEANCOULD_APP_KEY)
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }

    private fun initStetho() {
        Stetho.initializeWithDefaults(this)
    }

    fun initUserComponent() {
        getSharedPreferences("auth", Context.MODE_PRIVATE).edit().putBoolean("auto_login", true).apply()
    }

    fun releaseUserComponent() {
        getSharedPreferences("auth", Context.MODE_PRIVATE).edit().putBoolean("auto_login", false).apply()
    }
}


