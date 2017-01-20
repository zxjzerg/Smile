package com.zxjdev.smile.presentation.moment.create;

import com.zxjdev.smile.domain.moment.AddMomentUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public class NewMomentModule {

    @Provides
    NewMomentContract.Presenter providePresenter(AddMomentUseCase addMomentUseCase) {
        return new NewMomentPresenter(addMomentUseCase);
    }
}
