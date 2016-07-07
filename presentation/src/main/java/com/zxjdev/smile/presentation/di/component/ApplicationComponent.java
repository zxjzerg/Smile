package com.zxjdev.smile.presentation.di.component;

import android.content.Context;

import com.zxjdev.smile.presentation.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;
import rx.Scheduler;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    Context context();

    Scheduler scheduler();
}
