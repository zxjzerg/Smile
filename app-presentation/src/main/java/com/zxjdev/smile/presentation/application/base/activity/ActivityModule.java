package com.zxjdev.smile.presentation.application.base.activity;

import android.app.Activity;
import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.zxjdev.smile.presentation.application.di.DiConstant;
import com.zxjdev.smile.presentation.application.di.scope.ActivityScope;
import com.zxjdev.smile.presentation.application.util.image.ImageLoader;
import com.zxjdev.smile.presentation.application.util.image.SmileImageLoader;
import com.zxjdev.smile.presentation.application.util.ui.ErrorMessagePrinter;

import javax.inject.Named;

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
    @Named(DiConstant.ACTIVITY_IMAGE_LOADER)
    ImageLoader provideImageLoader(Context context) {
        RequestManager requestManager = Glide.with(activity);
        return new SmileImageLoader(context, requestManager);
    }

    @Provides
    @ActivityScope
    ErrorMessagePrinter provideErrorMessagePrinter(Context context) {
        return new ErrorMessagePrinter(context);
    }
}
