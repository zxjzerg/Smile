package com.zxjdev.smile.presentation.moment.list.di;

import com.zxjdev.smile.presentation.application.di.DiConstant;
import com.zxjdev.smile.presentation.application.di.scope.FragmentScope;
import com.zxjdev.smile.presentation.application.util.image.ImageLoader;
import com.zxjdev.smile.presentation.moment.list.MomentListContract;
import com.zxjdev.smile.presentation.moment.list.MomentListPresenter;
import com.zxjdev.smile.presentation.moment.list.adapter.MomentAdapter;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class MomentListFragmentModule {

    private MomentListContract.View view;

    public MomentListFragmentModule(MomentListContract.View view) {
        this.view = view;
    }

    @Provides
    @FragmentScope
    MomentAdapter provideMomentAdapter(@Named(DiConstant.FRAGMENT_IMAGE_LOADER) ImageLoader imageLoader) {
        return new MomentAdapter(imageLoader);
    }

    @Provides
    @FragmentScope
    MomentListContract.View provideView() {
        return view;
    }

    @Provides
    @FragmentScope
    MomentListContract.Presenter providePresenter(MomentListPresenter presenter) {
        return presenter;
    }
}
