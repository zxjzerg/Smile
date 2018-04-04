package com.zxjdev.smile.presentation.common.di.module

import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

@Module
class PresentationModule {

    @Provides
    fun providePresentationScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}