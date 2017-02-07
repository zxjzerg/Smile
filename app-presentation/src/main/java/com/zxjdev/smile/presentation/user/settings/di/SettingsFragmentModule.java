package com.zxjdev.smile.presentation.user.settings.di;

import com.zxjdev.smile.domain.user.LogoutUseCase;
import com.zxjdev.smile.presentation.application.di.scope.FragmentScope;
import com.zxjdev.smile.presentation.user.settings.SettingsContract;
import com.zxjdev.smile.presentation.user.settings.SettingsPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class SettingsFragmentModule {

    private SettingsContract.View view;

    public SettingsFragmentModule(SettingsContract.View view) {
        this.view = view;
    }

    @Provides
    @FragmentScope
    SettingsContract.Presenter providePresenter(LogoutUseCase logoutUseCase) {
        return new SettingsPresenter(view, logoutUseCase);
    }
}
