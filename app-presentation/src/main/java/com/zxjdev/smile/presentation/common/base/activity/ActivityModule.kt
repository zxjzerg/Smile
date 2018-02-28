package com.zxjdev.smile.presentation.common.base.activity

import android.content.Context

import com.zxjdev.smile.presentation.common.di.scope.ActivityScope
import com.zxjdev.smile.presentation.common.util.ui.ErrorMessagePrinter

import dagger.Module
import dagger.Provides

@Module
class ActivityModule {

    @Provides
    @ActivityScope
    internal fun provideErrorMessagePrinter(context: Context): ErrorMessagePrinter {
        return ErrorMessagePrinter(context)
    }
}
