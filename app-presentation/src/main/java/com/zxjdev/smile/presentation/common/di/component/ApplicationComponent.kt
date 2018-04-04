package com.zxjdev.smile.presentation.common.di.component

import android.app.Application
import com.zxjdev.smile.presentation.common.SmileApplication
import com.zxjdev.smile.presentation.common.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        AuthorizationDomainModule::class,
        MomentDomainModule::class,
        UserDomainModule::class,
        ActivityBindingModule::class,
        PresentationModule::class))
interface ApplicationComponent : AndroidInjector<SmileApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): ApplicationComponent.Builder

        fun build(): ApplicationComponent
    }
}
