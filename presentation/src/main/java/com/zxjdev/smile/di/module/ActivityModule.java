package com.zxjdev.smile.di.module;

import android.app.Activity;
import android.os.Handler;

import com.zxjdev.smile.di.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @PerActivity
    @Provides
    public Activity provideActivity() {
        return activity;
    }

    @PerActivity
    @Provides
    Handler provideHandler() {
        return new Handler();
    }
}
