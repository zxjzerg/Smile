package com.zxjdev.smile.presentation.moment.create.di;

import com.zxjdev.smile.presentation.moment.create.NewMomentActivity;

import dagger.Subcomponent;

@Subcomponent(modules = {
    NewMomentModule.class
})
public interface NewMomentComponent {

    void inject(NewMomentActivity activity);
}
