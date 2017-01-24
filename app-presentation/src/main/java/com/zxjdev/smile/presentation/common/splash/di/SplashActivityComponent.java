package com.zxjdev.smile.presentation.common.splash.di;

import com.zxjdev.smile.presentation.common.splash.SplashActivity;

import dagger.Subcomponent;

@Subcomponent(modules = {
    SplashActivityModule.class
})
public interface SplashActivityComponent {

    void inject(SplashActivity activity);
}
