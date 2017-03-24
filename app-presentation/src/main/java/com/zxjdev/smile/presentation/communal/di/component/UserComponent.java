package com.zxjdev.smile.presentation.communal.di.component;

import com.zxjdev.smile.presentation.communal.base.activity.ActivityModule;
import com.zxjdev.smile.presentation.communal.di.module.MomentDomainModule;
import com.zxjdev.smile.presentation.communal.di.module.UserDomainModule;
import com.zxjdev.smile.presentation.infrastucture.main.di.MainActivityComponent;
import com.zxjdev.smile.presentation.infrastucture.main.di.MainActivityModule;
import com.zxjdev.smile.presentation.moment.create.di.NewMomentActivityComponent;
import com.zxjdev.smile.presentation.moment.create.di.NewMomentActivityModule;

import dagger.Subcomponent;

@Subcomponent(modules = {MomentDomainModule.class, UserDomainModule.class})
public interface UserComponent {

  NewMomentActivityComponent getNewMomentActivityComponent(ActivityModule activityModule,
    NewMomentActivityModule newMomentActivityModule);

  MainActivityComponent getMainActivityComponent(ActivityModule activityModule, MainActivityModule mainActivityModule);
}
