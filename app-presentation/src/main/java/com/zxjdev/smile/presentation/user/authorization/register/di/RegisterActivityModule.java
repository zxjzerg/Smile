package com.zxjdev.smile.presentation.user.authorization.register.di;

import com.zxjdev.smile.domain.user.RegisterUseCase;
import com.zxjdev.smile.presentation.user.authorization.register.RegisterContract;
import com.zxjdev.smile.presentation.user.authorization.register.RegisterPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class RegisterActivityModule {

    @Provides
    RegisterContract.Presenter providePresenter(RegisterUseCase registerUseCase) {
        return new RegisterPresenter(registerUseCase);
    }
}
