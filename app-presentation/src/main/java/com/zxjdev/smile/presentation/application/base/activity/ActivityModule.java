package com.zxjdev.smile.presentation.application.base.activity;

import android.app.Activity;
import android.content.Context;

import com.zxjdev.smile.presentation.application.di.scope.ActivityScope;
import com.zxjdev.smile.presentation.application.util.ui.ErrorMessagePrinter;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    Activity provideActivity() {
        return activity;
    }

    @Provides
    @ActivityScope
    ErrorMessagePrinter provideErrorMessagePrinter(Context context) {
        return new ErrorMessagePrinter(context);
    }
}
