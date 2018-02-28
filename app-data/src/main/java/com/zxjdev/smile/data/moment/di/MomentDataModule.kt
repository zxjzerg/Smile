package com.zxjdev.smile.data.moment.di

import com.zxjdev.smile.data.moment.MomentDataRepository
import com.zxjdev.smile.data.moment.datasource.MomentCloudService
import com.zxjdev.smile.data.moment.datasource.MomentCloudServiceLeanCloudImpl
import com.zxjdev.smile.domain.moment.MomentRepository

import dagger.Module
import dagger.Provides

@Module
class MomentDataModule {

    @Provides
    internal fun provideMomentService(momentCloudService: MomentCloudServiceLeanCloudImpl): MomentCloudService {
        return momentCloudService
    }

    @Provides
    internal fun provideMomentRepository(momentDataRepository: MomentDataRepository): MomentRepository {
        return momentDataRepository
    }
}
