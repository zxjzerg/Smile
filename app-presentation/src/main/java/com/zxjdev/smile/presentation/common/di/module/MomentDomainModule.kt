package com.zxjdev.smile.presentation.common.di.module

import com.zxjdev.smile.data.moment.di.MomentDataModule
import com.zxjdev.smile.domain.moment.MomentRepository
import com.zxjdev.smile.domain.moment.usecase.AddMoment
import com.zxjdev.smile.domain.moment.usecase.GetMomentList

import dagger.Module
import dagger.Provides

@Module(includes = arrayOf(MomentDataModule::class))
class MomentDomainModule {

    @Provides
    internal fun provideAddMoment(momentRepository: MomentRepository): AddMoment {
        return AddMoment(momentRepository)
    }

    @Provides
    internal fun provideGetMomentList(momentRepository: MomentRepository): GetMomentList {
        return GetMomentList(momentRepository)
    }
}
