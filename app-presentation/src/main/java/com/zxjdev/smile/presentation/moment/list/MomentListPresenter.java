package com.zxjdev.smile.presentation.moment.list;

import com.zxjdev.smile.domain.moment.GetMomentListUseCase;
import com.zxjdev.smile.domain.moment.Moment;
import com.zxjdev.smile.presentation.application.DefaultSubscriber;

import java.util.List;

public class MomentListPresenter implements MomentListContract.Presenter {

    private MomentListContract.View view;
    private GetMomentListUseCase getMomentListUseCase;

    public MomentListPresenter(MomentListContract.View view,
        GetMomentListUseCase getMomentListUseCase) {
        this.view = view;
        this.getMomentListUseCase = getMomentListUseCase;
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

            }
        });
    }
}
