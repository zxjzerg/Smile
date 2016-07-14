package com.zxjdev.smile.presentation.presenter.moment;

import com.zxjdev.smile.domain.interactor.AddMomentUseCase;
import com.zxjdev.smile.presentation.presenter.DefaultSubscriber;
import com.zxjdev.smile.presentation.view.i.moment.INewMomentView;

import javax.inject.Inject;

public class NewMomentPresenter {

    private AddMomentUseCase mAddMomentUseCase;
    private INewMomentView mView;

    @Inject
    public NewMomentPresenter(AddMomentUseCase addMomentUseCase) {
        mAddMomentUseCase = addMomentUseCase;
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
