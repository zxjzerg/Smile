package com.zxjdev.smile.presentation.moment.list;

import com.zxjdev.smile.domain.moment.GetMomentListUseCase;
import com.zxjdev.smile.domain.moment.Moment;
import com.zxjdev.smile.presentation.application.DefaultSubscriber;

import java.util.List;

public class MomentsPresenter implements MomentsContract.Presenter {

    private MomentsContract.View mView;
    private GetMomentListUseCase mGetMomentListUseCase;

    public MomentsPresenter(GetMomentListUseCase getMomentListUseCase) {
        mGetMomentListUseCase = getMomentListUseCase;
    }

    @Override
    public void setView(MomentsContract.View view) {
        mView = view;
    }

    @Override
    public void create() {
        loadMoments();
    }

    @Override
    public void loadMoments() {
        mGetMomentListUseCase.execute(new DefaultSubscriber<List<Moment>>(mView.context()) {
            @Override
            public void onNext(List<Moment> data) {

            }
        });
    }
}
