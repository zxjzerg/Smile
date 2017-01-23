package com.zxjdev.smile.presentation.application.base.activity;

import android.app.Activity;

import com.zxjdev.smile.presentation.application.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @ActivityScope
    @Provides
    Activity provideActivity() {
        return activity;
    }
}
