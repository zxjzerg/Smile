package com.zxjdev.smile.presentation.moment;

import com.zxjdev.smile.domain.base.UseCaseConfig;
import com.zxjdev.smile.domain.moment.MomentRepository;
import com.zxjdev.smile.domain.moment.usecase.AddMoment;
import com.zxjdev.smile.domain.moment.usecase.GetMomentList;

import dagger.Module;
import dagger.Provides;

@Module
public class MomentUseCaseModule {

    @Provides
    AddMoment provideAddMoment(UseCaseConfig useCaseConfig, MomentRepository momentRepository) {
        return new AddMoment(useCaseConfig, momentRepository);
    }

    @Provides
    GetMomentList provideGetMomentList(UseCaseConfig useCaseConfig,
        MomentRepository momentRepository) {
        return new GetMomentList(useCaseConfig, momentRepository);
    }
}
