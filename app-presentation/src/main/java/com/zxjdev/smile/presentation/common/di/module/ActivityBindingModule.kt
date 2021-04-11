package com.zxjdev.smile.presentation.common.di.module

import com.zxjdev.smile.presentation.authorization.login.LoginActivity
import com.zxjdev.smile.presentation.authorization.register.RegisterActivity
import com.zxjdev.smile.presentation.common.base.activity.ActivityModule
import com.zxjdev.smile.presentation.common.di.scope.ActivityScope
import com.zxjdev.smile.presentation.flutter.SmileFlutterActivity
import com.zxjdev.smile.presentation.infrastucture.main.MainActivity
import com.zxjdev.smile.presentation.infrastucture.main.MainActivityModule
import com.zxjdev.smile.presentation.infrastucture.splash.SplashActivity
import com.zxjdev.smile.presentation.moment.create.NewMomentActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [ActivityModule::class])
    internal abstract fun splashActivity(): SplashActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [ActivityModule::class])
    internal abstract fun loginActivity(): LoginActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [ActivityModule::class])
    internal abstract fun registerActivity(): RegisterActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    internal abstract fun mainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [ActivityModule::class])
    internal abstract fun newMomentActivity(): NewMomentActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [ActivityModule::class])
    internal abstract fun simleFlutterActivity(): SmileFlutterActivity
}
