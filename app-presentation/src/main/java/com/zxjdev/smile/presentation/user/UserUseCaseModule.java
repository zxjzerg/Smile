package com.zxjdev.smile.presentation.user;

import com.zxjdev.smile.domain.base.UseCaseConfig;
import com.zxjdev.smile.domain.user.UserRepository;
import com.zxjdev.smile.domain.user.usecase.AutoLogin;
import com.zxjdev.smile.domain.user.usecase.GetCurrentUser;
import com.zxjdev.smile.domain.user.usecase.Login;
import com.zxjdev.smile.domain.user.usecase.Logout;
import com.zxjdev.smile.domain.user.usecase.Register;
import com.zxjdev.smile.domain.user.usecase.UploadAvatar;

import dagger.Module;
import dagger.Provides;

@Module
public class UserUseCaseModule {

    @Provides
    AutoLogin provideAutoLogin(UseCaseConfig useCaseConfig, UserRepository userRepository) {
        return new AutoLogin(useCaseConfig, userRepository);
    }

    @Provides
    Login provideLogin(UseCaseConfig useCaseConfig, UserRepository userRepository) {
        return new Login(useCaseConfig, userRepository);
    }

    @Provides
    Logout provideLogout(UseCaseConfig useCaseConfig, UserRepository userRepository) {
        return new Logout(useCaseConfig, userRepository);
    }

    @Provides
    Register provideRegister(UseCaseConfig useCaseConfig, UserRepository userRepository) {
        return new Register(useCaseConfig, userRepository);
    }

    @Provides
    GetCurrentUser provideGetCurrentUser(UseCaseConfig useCaseConfig,
        UserRepository userRepository) {
        return new GetCurrentUser(useCaseConfig, userRepository);
    }

    @Provides
    UploadAvatar provideUploadAvatar(UseCaseConfig useCaseConfig,
        UserRepository userRepository) {
        return new UploadAvatar(useCaseConfig, userRepository);
    }
}
