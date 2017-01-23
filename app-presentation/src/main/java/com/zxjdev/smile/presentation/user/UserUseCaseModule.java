package com.zxjdev.smile.presentation.user;

import com.zxjdev.smile.domain.base.UseCaseConfig;
import com.zxjdev.smile.domain.user.AutoLoginUseCase;
import com.zxjdev.smile.domain.user.LoginUseCase;
import com.zxjdev.smile.domain.user.LogoutUseCase;
import com.zxjdev.smile.domain.user.RegisterUseCase;
import com.zxjdev.smile.domain.user.UserRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class UserUseCaseModule {

    @Provides
    AutoLoginUseCase provideAutoLoginUseCase(UseCaseConfig useCaseConfig,
        UserRepository userRepository) {
        return new AutoLoginUseCase(useCaseConfig, userRepository);
    }

    @Provides
    LoginUseCase provideLoginUseCase(UseCaseConfig useCaseConfig, UserRepository userRepository) {
        return new LoginUseCase(useCaseConfig, userRepository);
    }

    @Provides
    LogoutUseCase provideLogoutUseCase(UseCaseConfig useCaseConfig, UserRepository userRepository) {
        return new LogoutUseCase(useCaseConfig, userRepository);
    }

    @Provides
    RegisterUseCase provideRegisterUseCase(UseCaseConfig useCaseConfig,
        UserRepository userRepository) {
        return new RegisterUseCase(useCaseConfig, userRepository);
    }
}
