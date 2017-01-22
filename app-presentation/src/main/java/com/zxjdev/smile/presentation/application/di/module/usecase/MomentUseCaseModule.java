package com.zxjdev.smile.presentation.application.di.module.usecase;

import com.zxjdev.smile.domain.base.UseCaseConfig;
import com.zxjdev.smile.domain.moment.AddMomentUseCase;
import com.zxjdev.smile.domain.moment.GetMomentListUseCase;
import com.zxjdev.smile.domain.moment.MomentRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class MomentUseCaseModule {

    @Provides
    AddMomentUseCase provideAddMomentUseCase(UseCaseConfig useCaseConfig,
        MomentRepository momentRepository) {
        return new AddMomentUseCase(useCaseConfig, momentRepository);
    }

    @Provides
    GetMomentListUseCase provideGetMomentListUseCase(UseCaseConfig useCaseConfig,
        MomentRepository momentRepository) {
        return new GetMomentListUseCase(useCaseConfig, momentRepository);
    }
}
