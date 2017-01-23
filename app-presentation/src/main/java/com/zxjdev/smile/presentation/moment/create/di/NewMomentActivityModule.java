package com.zxjdev.smile.presentation.moment.create.di;

import com.zxjdev.smile.domain.moment.AddMomentUseCase;
import com.zxjdev.smile.presentation.moment.create.NewMomentContract;
import com.zxjdev.smile.presentation.moment.create.NewMomentPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class NewMomentActivityModule {

    @Provides
    NewMomentContract.Presenter providePresenter(AddMomentUseCase addMomentUseCase) {
        return new NewMomentPresenter(addMomentUseCase);
    }
}
