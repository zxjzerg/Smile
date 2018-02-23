package com.zxjdev.smile.presentation.common.di.component;

import com.zxjdev.smile.presentation.common.base.activity.ActivityModule;
import com.zxjdev.smile.presentation.common.di.module.MomentDomainModule;
import com.zxjdev.smile.presentation.common.di.module.UserDomainModule;
import com.zxjdev.smile.presentation.infrastucture.main.di.MainActivityComponent;
import com.zxjdev.smile.presentation.moment.create.di.NewMomentActivityComponent;

import dagger.Subcomponent;

@Subcomponent(modules = {MomentDomainModule.class, UserDomainModule.class})
public interface UserComponent {

  NewMomentActivityComponent getNewMomentActivityComponent(ActivityModule activityModule);

  MainActivityComponent getMainActivityComponent(ActivityModule activityModule);
}
