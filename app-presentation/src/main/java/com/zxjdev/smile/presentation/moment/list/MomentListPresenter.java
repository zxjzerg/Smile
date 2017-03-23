package com.zxjdev.smile.presentation.moment.list;

import com.zxjdev.smile.domain.moment.Moment;
import com.zxjdev.smile.domain.moment.usecase.GetMomentList;
import com.zxjdev.smile.presentation.application.DefaultSubscriber;
import com.zxjdev.smile.presentation.application.util.ui.ErrorMessagePrinter;
import com.zxjdev.smile.presentation.moment.MomentModel;
import com.zxjdev.smile.presentation.moment.MomentModelMapper;

import java.util.List;

import javax.inject.Inject;

public class MomentListPresenter implements MomentListContract.Presenter {

  @Inject MomentListContract.View view;
  @Inject GetMomentList getMomentList;
  @Inject MomentModelMapper momentModelMapper;
  @Inject ErrorMessagePrinter errorMessagePrinter;

  @Inject
  public MomentListPresenter() {

  }

  @Override
  public void create() {
    loadMoments();
  }

  @Override
  public void loadMoments() {
    getMomentList.execute(new DefaultSubscriber<List<Moment>>(errorMessagePrinter) {
      @Override
      public void onNext(List<Moment> data) {
        List<MomentModel> momentModels = momentModelMapper.transform(data);
        view.displayMomentList(momentModels);
      }
    });
  }

  @Override
  public void refreshMoments() {
    getMomentList.execute(new DefaultSubscriber<List<Moment>>(errorMessagePrinter) {
      @Override
      public void onNext(List<Moment> data) {
        List<MomentModel> momentModels = momentModelMapper.transform(data);
        view.displayMomentList(momentModels);
        view.dismissRefreshingView();
      }
    });
  }
}
