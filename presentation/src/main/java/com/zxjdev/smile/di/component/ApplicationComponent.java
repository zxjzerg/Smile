package com.zxjdev.smile.di.component;

import android.content.Context;

import com.zxjdev.smile.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    Context context();
}
