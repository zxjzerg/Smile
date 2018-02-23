package com.zxjdev.smile.presentation.moment.create;

import com.zxjdev.smile.domain.moment.usecase.AddMoment;
import com.zxjdev.smile.presentation.common.DefaultSubscriber;
import com.zxjdev.smile.presentation.common.util.ui.ErrorMessagePrinter;

import javax.inject.Inject;

public class NewMomentPresenter implements NewMomentContract.Presenter {

  private NewMomentContract.View view;
  @Inject AddMoment addMoment;
  @Inject ErrorMessagePrinter errorMessagePrinter;

  @Inject
  NewMomentPresenter() {

  }

  public void handleAddMoment(String content) {
    addMoment.execute(new AddMoment.RequestParams(content), new DefaultSubscriber<Void>(errorMessagePrinter) {
      @Override
      public void onComplete() {
        super.onComplete();
        view.close();
      }
    });
  }

  @Override
  public void takeView(NewMomentContract.View view) {
    this.view = view;
  }

  @Override
  public void dropView() {
    this.view = null;
    addMoment.unsubscribe();
  }
}
