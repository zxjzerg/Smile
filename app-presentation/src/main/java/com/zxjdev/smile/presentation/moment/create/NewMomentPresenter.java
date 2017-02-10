package com.zxjdev.smile.presentation.moment.create;

import com.zxjdev.smile.domain.moment.AddMomentUseCase;
import com.zxjdev.smile.presentation.application.DefaultSubscriber;

import javax.inject.Inject;

public class NewMomentPresenter implements NewMomentContract.Presenter {

    @Inject NewMomentContract.View view;
    @Inject AddMomentUseCase addMomentUseCase;

    @Inject
    public NewMomentPresenter() {

    }

    public void handleAddMoment(String content) {
        addMomentUseCase.execute(new AddMomentUseCase.RequestParams(content),
            new DefaultSubscriber<Void>(view.context()) {
                @Override
                public void onCompleted() {
                    super.onCompleted();
                    view.close();
                }
            });
    }

    public void destroy() {
        addMomentUseCase.unSubscribe();
    }
}
