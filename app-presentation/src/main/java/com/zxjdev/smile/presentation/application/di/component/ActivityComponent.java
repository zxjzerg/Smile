package com.zxjdev.smile.presentation.application.di.component;

import com.zxjdev.smile.presentation.application.di.module.ActivityModule;
import com.zxjdev.smile.presentation.application.di.scope.ActivityScope;
import com.zxjdev.smile.presentation.common.main.MainActivity;
import com.zxjdev.smile.presentation.common.splash.SplashActivity;
import com.zxjdev.smile.presentation.moment.create.NewMomentActivity;
import com.zxjdev.smile.presentation.user.authorization.login.LoginActivity;
import com.zxjdev.smile.presentation.user.authorization.register.RegisterActivity;
import com.zxjdev.smile.presentation.user.settings.SettingsFragment;

import dagger.Subcomponent;

@Subcomponent(
    modules = {
        ActivityModule.class
    })
@ActivityScope
public interface ActivityComponent {

    void inject(LoginActivity activity);

    void inject(MainActivity activity);

    void inject(NewMomentActivity activity);

    void inject(RegisterActivity activity);

    void inject(SplashActivity activity);

    void inject(SettingsFragment fragment);
}
