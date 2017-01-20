package com.zxjdev.smile.presentation.moment.create;

import com.zxjdev.smile.domain.moment.AddMomentUseCase;
import com.zxjdev.smile.presentation.application.DefaultSubscriber;

public class NewMomentPresenter implements NewMomentContract.Presenter {

    private NewMomentContract.View mView;

    private AddMomentUseCase mAddMomentUseCase;

    public NewMomentPresenter(AddMomentUseCase addMomentUseCase) {
        mAddMomentUseCase = addMomentUseCase;
    }

    public void setView(NewMomentContract.View view) {
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
