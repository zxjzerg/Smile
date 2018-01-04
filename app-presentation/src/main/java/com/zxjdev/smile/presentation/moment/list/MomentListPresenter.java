package com.zxjdev.smile.presentation.moment.list;

import android.os.Bundle;

import com.zxjdev.smile.domain.moment.Moment;
import com.zxjdev.smile.domain.moment.usecase.GetMomentList;
import com.zxjdev.smile.presentation.common.DefaultSubscriber;
import com.zxjdev.smile.presentation.common.util.ui.ErrorMessagePrinter;
import com.zxjdev.smile.presentation.moment.MomentModel;
import com.zxjdev.smile.presentation.moment.MomentModelMapper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MomentListPresenter implements MomentListContract.Presenter {

  private static final String EXTRA_MOMENT_LIST = "extra_moment_list";

  @Inject MomentListContract.View view;
  @Inject GetMomentList getMomentList;
  @Inject MomentModelMapper momentModelMapper;
  @Inject ErrorMessagePrinter errorMessagePrinter;

  private ArrayList<MomentModel> moments = new ArrayList<>();

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
        moments.clear();
        moments.addAll(momentModelMapper.transform(data));
        view.displayMomentList(moments);
      }
    });
  }

  @Override
  public void refreshMoments() {
    getMomentList.execute(new DefaultSubscriber<List<Moment>>(errorMessagePrinter) {
      @Override
      public void onNext(List<Moment> data) {
        moments.clear();
        moments.addAll(momentModelMapper.transform(data));
        view.displayMomentList(moments);
        view.dismissRefreshingView();
      }
    });
  }

  @Override
  public void saveInstanceState(Bundle outState) {
    outState.putParcelableArrayList(EXTRA_MOMENT_LIST, moments);
  }

  @Override
  public void loadSavedInstanceState(Bundle savedInstanceState) {
    if (savedInstanceState == null) return;

    ArrayList<MomentModel> moments = savedInstanceState.getParcelableArrayList(EXTRA_MOMENT_LIST);
    if (moments != null) {
      this.moments = moments;
      view.displayMomentList(moments);
    }
  }
}
