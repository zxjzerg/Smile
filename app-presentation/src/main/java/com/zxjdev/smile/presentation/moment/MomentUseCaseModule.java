package com.zxjdev.smile.presentation.moment;

import com.zxjdev.smile.domain.base.SchedulerFactory;
import com.zxjdev.smile.domain.moment.MomentRepository;
import com.zxjdev.smile.domain.moment.usecase.AddMoment;
import com.zxjdev.smile.domain.moment.usecase.GetMomentList;

import dagger.Module;
import dagger.Provides;

@Module
public class MomentUseCaseModule {

    @Provides
    AddMoment provideAddMoment(SchedulerFactory schedulerFactory,
        MomentRepository momentRepository) {
        return new AddMoment(schedulerFactory, momentRepository);
    }

    @Provides
    GetMomentList provideGetMomentList(SchedulerFactory schedulerFactory,
        MomentRepository momentRepository) {
        return new GetMomentList(schedulerFactory, momentRepository);
    }
}
