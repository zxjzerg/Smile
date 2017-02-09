package com.zxjdev.smile.presentation.moment.list;

import com.zxjdev.smile.domain.moment.GetMomentListUseCase;
import com.zxjdev.smile.domain.moment.Moment;
import com.zxjdev.smile.presentation.application.DefaultSubscriber;
import com.zxjdev.smile.presentation.moment.MomentModel;
import com.zxjdev.smile.presentation.moment.MomentModelMapper;

import java.util.List;

import javax.inject.Inject;

public class MomentListPresenter implements MomentListContract.Presenter {

    @Inject MomentListContract.View view;
    @Inject GetMomentListUseCase getMomentListUseCase;
    @Inject MomentModelMapper momentModelMapper;

    @Inject
    public MomentListPresenter() {

    }

    @Override
    public void create() {
        loadMoments();
    }

    @Override
    public void loadMoments() {
        getMomentListUseCase.execute(new DefaultSubscriber<List<Moment>>(view.context()) {
            @Override
            public void onNext(List<Moment> data) {
                List<MomentModel> momentModels = momentModelMapper.transform(data);
                view.displayMomentList(momentModels);
            }
        });
    }
}
