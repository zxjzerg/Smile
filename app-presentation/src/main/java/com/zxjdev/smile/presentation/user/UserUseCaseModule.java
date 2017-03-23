package com.zxjdev.smile.presentation.user;

import com.zxjdev.smile.domain.base.SchedulerFactory;
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
    AutoLogin provideAutoLogin(SchedulerFactory schedulerFactory, UserRepository userRepository) {
        return new AutoLogin(schedulerFactory, userRepository);
    }

    @Provides
    Login provideLogin(SchedulerFactory schedulerFactory, UserRepository userRepository) {
        return new Login(schedulerFactory, userRepository);
    }

    @Provides
    Logout provideLogout(SchedulerFactory schedulerFactory, UserRepository userRepository) {
        return new Logout(schedulerFactory, userRepository);
    }

    @Provides
    Register provideRegister(SchedulerFactory schedulerFactory, UserRepository userRepository) {
        return new Register(schedulerFactory, userRepository);
    }

    @Provides
    GetCurrentUser provideGetCurrentUser(SchedulerFactory schedulerFactory,
        UserRepository userRepository) {
        return new GetCurrentUser(schedulerFactory, userRepository);
    }

    @Provides
    UploadAvatar provideUploadAvatar(SchedulerFactory schedulerFactory,
        UserRepository userRepository) {
        return new UploadAvatar(schedulerFactory, userRepository);
    }
}
