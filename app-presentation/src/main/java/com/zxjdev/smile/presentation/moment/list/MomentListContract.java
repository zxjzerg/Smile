package com.zxjdev.smile.presentation.moment.list;

import com.zxjdev.smile.presentation.moment.MomentModel;

import java.util.List;

public interface MomentListContract {

  interface View {

    void displayMomentList(List<MomentModel> momentModels);

    void dismissRefreshingView();
  }

  interface Presenter {

    void create();

    void loadMoments();

    void refreshMoments();
  }
}
