package com.zxjdev.smile.presentation.moment.create;

import com.zxjdev.smile.domain.moment.AddMomentUseCase;
import com.zxjdev.smile.presentation.application.DefaultSubscriber;

public class NewMomentPresenter implements NewMomentContract.Presenter {

    private NewMomentContract.View view;

    private AddMomentUseCase addMomentUseCase;

    public NewMomentPresenter(AddMomentUseCase addMomentUseCase) {
        this.addMomentUseCase = addMomentUseCase;
    }

    public void setView(NewMomentContract.View view) {
        this.view = view;
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
