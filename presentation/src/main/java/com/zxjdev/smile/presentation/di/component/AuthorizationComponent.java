package com.zxjdev.smile.presentation.di.component;

import com.zxjdev.smile.presentation.di.module.ActivityModule;
import com.zxjdev.smile.presentation.di.module.RepositoryModule;
import com.zxjdev.smile.presentation.di.scope.PerActivity;
import com.zxjdev.smile.presentation.view.activity.authorization.LoginActivity;
import com.zxjdev.smile.presentation.view.activity.authorization.RegisterActivity;
import com.zxjdev.smile.presentation.view.activity.authorization.SplashActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {
        ActivityModule.class, RepositoryModule.class
})
public interface AuthorizationComponent {

    void inject(RegisterActivity activity);

    void inject(LoginActivity activity);

    void inject(SplashActivity activity);
}
