package com.zxjdev.smile.presentation.application.di.component;

import com.zxjdev.smile.presentation.application.di.module.ActivityModule;
import com.zxjdev.smile.presentation.application.di.module.ApplicationModule;
import com.zxjdev.smile.presentation.application.di.module.MainActivityModule;
import com.zxjdev.smile.presentation.application.di.module.NetworkModule;
import com.zxjdev.smile.presentation.application.di.module.RepositoryModule;
import com.zxjdev.smile.presentation.application.di.module.usecase.MomentUseCaseModule;
import com.zxjdev.smile.presentation.application.di.module.usecase.UserUseCaseModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
    ApplicationModule.class,
    NetworkModule.class,
    RepositoryModule.class,
    UserUseCaseModule.class,
    MomentUseCaseModule.class
})
public interface ApplicationComponent {

    ActivityComponent getActivityComponent(ActivityModule activityModule);

    MainActivityComponent plus(ActivityModule activityModule,
        MainActivityModule mainActivityModule);
}
