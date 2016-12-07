package com.zxjdev.smile.presentation.moment.create;

import com.zxjdev.smile.domain.moment.AddMomentUseCase;
import com.zxjdev.smile.presentation.application.DefaultSubscriber;

import javax.inject.Inject;

public class NewMomentPresenter {

    @Inject AddMomentUseCase mAddMomentUseCase;
    private INewMomentView mView;

    @Inject
    public NewMomentPresenter() {

    }

    public void setView(INewMomentView view) {
        mView = view;
    }

    public void handleAddMoment(String content) {
        mAddMomentUseCase.setInput(content);
        mAddMomentUseCase.execute(new DefaultSubscriber<Void>(mView.context()) {
            @Override
            public void onCompleted() {
                super.onCompleted();
                mView.close();
            }
        });
    }

    public void destroy() {
        mAddMomentUseCase.unSubscribe();
    }
}
