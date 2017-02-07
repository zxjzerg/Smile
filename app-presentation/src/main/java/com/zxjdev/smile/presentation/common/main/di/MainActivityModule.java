package com.zxjdev.smile.presentation.common.main.di;

import com.zxjdev.smile.presentation.common.main.MainContract;
import com.zxjdev.smile.presentation.common.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    private MainContract.View view;

    public MainActivityModule(MainContract.View view) {
        this.view = view;
    }

    @Provides
    MainContract.Presenter providePresenter() {
        return new MainPresenter(view);
    }
}
