package com.zxjdev.smile.presentation.common.di.module;

import com.zxjdev.smile.data.moment.di.MomentDataModule;
import com.zxjdev.smile.domain.common.SchedulerFactory;
import com.zxjdev.smile.domain.moment.MomentRepository;
import com.zxjdev.smile.domain.moment.usecase.AddMoment;
import com.zxjdev.smile.domain.moment.usecase.GetMomentList;

import dagger.Module;
import dagger.Provides;

@Module(includes = {MomentDataModule.class})
public class MomentDomainModule {

  @Provides
  AddMoment provideAddMoment(SchedulerFactory schedulerFactory, MomentRepository momentRepository) {
    return new AddMoment(schedulerFactory, momentRepository);
  }

  @Provides
  GetMomentList provideGetMomentList(SchedulerFactory schedulerFactory, MomentRepository momentRepository) {
    return new GetMomentList(schedulerFactory, momentRepository);
  }
}
