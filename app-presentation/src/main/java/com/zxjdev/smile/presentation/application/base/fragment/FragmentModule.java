package com.zxjdev.smile.presentation.application.base.fragment;

import android.app.Fragment;
import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.zxjdev.smile.presentation.application.di.DiConstant;
import com.zxjdev.smile.presentation.application.di.scope.FragmentScope;
import com.zxjdev.smile.presentation.application.util.image.ImageLoader;
import com.zxjdev.smile.presentation.application.util.image.SmileImageLoader;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class FragmentModule {

    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @FragmentScope
    RequestManager provideRequestManager() {
        return Glide.with(fragment);
    }

    @Provides
    @FragmentScope
    @Named(DiConstant.FRAGMENT_IMAGE_LOADER)
    ImageLoader provideImageLoader(Context context) {
        RequestManager requestManager = Glide.with(fragment);
        return new SmileImageLoader(context, requestManager);
    }
}
