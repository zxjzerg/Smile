package com.zxjdev.smile.presentation.application.di.module;

import com.zxjdev.smile.domain.moment.GetMomentListUseCase;
import com.zxjdev.smile.presentation.application.di.scope.FragmentScope;
import com.zxjdev.smile.presentation.moment.list.MomentAdapter;
import com.zxjdev.smile.presentation.moment.list.MomentsContract;
import com.zxjdev.smile.presentation.moment.list.MomentsPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MomentsFragmentModule {

    @Provides
    @FragmentScope
    MomentAdapter provideMomentAdapter() {
        return new MomentAdapter();
    }

    @Provides
    @FragmentScope
    MomentsContract.Presenter providePresenter(GetMomentListUseCase getMomentListUseCase) {
        return new MomentsPresenter(getMomentListUseCase);
    }
}
