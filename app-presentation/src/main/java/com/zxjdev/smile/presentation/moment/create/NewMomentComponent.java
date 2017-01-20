package com.zxjdev.smile.presentation.moment.create;

import dagger.Subcomponent;

@Subcomponent(modules = {
    NewMomentModule.class
})
public interface NewMomentComponent {

    void inject(NewMomentActivity activity);
}
