package com.zxjdev.smile.presentation.communal.di.module;

import com.zxjdev.smile.data.moment.MomentDataModule;
import com.zxjdev.smile.domain.communal.base.SchedulerFactory;
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
