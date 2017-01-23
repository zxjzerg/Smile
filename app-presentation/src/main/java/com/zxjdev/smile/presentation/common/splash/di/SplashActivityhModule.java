package com.zxjdev.smile.presentation.common.splash.di;

import com.zxjdev.smile.domain.user.AutoLoginUseCase;
import com.zxjdev.smile.presentation.common.splash.SplashContract;
import com.zxjdev.smile.presentation.common.splash.SplashPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class SplashActivityhModule {

    @Provides
    SplashContract.Presenter providePresenter(AutoLoginUseCase autoLoginUseCase) {
        return new SplashPresenter(autoLoginUseCase);
    }
}
