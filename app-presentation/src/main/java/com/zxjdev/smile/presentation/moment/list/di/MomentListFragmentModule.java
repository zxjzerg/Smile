package com.zxjdev.smile.presentation.moment.list.di;

import com.zxjdev.smile.domain.moment.GetMomentListUseCase;
import com.zxjdev.smile.presentation.application.di.scope.FragmentScope;
import com.zxjdev.smile.presentation.moment.list.adapter.MomentAdapter;
import com.zxjdev.smile.presentation.moment.list.MomentListContract;
import com.zxjdev.smile.presentation.moment.list.MomentListPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MomentListFragmentModule {

    @Provides
    @FragmentScope
    MomentAdapter provideMomentAdapter() {
        return new MomentAdapter();
    }

    @Provides
    @FragmentScope
    MomentListContract.Presenter providePresenter(GetMomentListUseCase getMomentListUseCase) {
        return new MomentListPresenter(getMomentListUseCase);
    }
}
