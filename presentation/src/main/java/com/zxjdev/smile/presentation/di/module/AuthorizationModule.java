package com.zxjdev.smile.presentation.di.module;

import com.zxjdev.smile.domain.interactor.RegisterUseCase;
import com.zxjdev.smile.presentation.di.scope.PerActivity;
import com.zxjdev.smile.presentation.presenter.RegisterPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class AuthorizationModule {

    @Provides
    @PerActivity
    RegisterPresenter provideRegisterPresenter(RegisterUseCase registerUseCase) {
        return new RegisterPresenter(registerUseCase);
    }

    /*@Provides
    @PerActivity
    RegisterUseCase provideRegisterUseCase(UserRepository userRepository, Scheduler scheduler) {
        return new RegisterUseCase(userRepository, scheduler);
    }*/
}
