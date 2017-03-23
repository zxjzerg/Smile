package com.zxjdev.smile.presentation.application.di.component;

import com.zxjdev.smile.data.di.DataModule;
import com.zxjdev.smile.data.di.NetworkModule;
import com.zxjdev.smile.data.di.RepositoryModule;
import com.zxjdev.smile.presentation.application.base.activity.ActivityComponent;
import com.zxjdev.smile.presentation.application.base.activity.ActivityModule;
import com.zxjdev.smile.presentation.application.di.module.ApplicationModule;
import com.zxjdev.smile.presentation.moment.MomentUseCaseModule;
import com.zxjdev.smile.presentation.user.UserUseCaseModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
    ApplicationModule.class,
    NetworkModule.class,
    RepositoryModule.class,
    UserUseCaseModule.class,
    MomentUseCaseModule.class,
    DataModule.class
})
public interface ApplicationComponent {

    ActivityComponent getActivityComponent(ActivityModule activityModule);
}
