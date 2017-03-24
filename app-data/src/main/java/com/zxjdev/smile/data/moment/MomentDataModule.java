package com.zxjdev.smile.data.moment;

import com.zxjdev.smile.data.moment.datasource.MomentCloudService;
import com.zxjdev.smile.data.moment.datasource.MomentCloudServiceLeanCloudImpl;
import com.zxjdev.smile.domain.moment.MomentRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class MomentDataModule {

  @Provides
  MomentCloudService provideMomentService(MomentCloudServiceLeanCloudImpl momentCloudService) {
    return momentCloudService;
  }

  @Provides
  MomentRepository provideMomentRepository(MomentDataRepository momentDataRepository) {
    return momentDataRepository;
  }
}
