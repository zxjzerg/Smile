package com.zxjdev.smile.presentation.moment.list;

import android.os.Bundle;

import com.zxjdev.smile.presentation.common.base.BasePresenter;
import com.zxjdev.smile.presentation.common.base.BaseView;
import com.zxjdev.smile.presentation.moment.MomentModel;

import java.util.List;

public interface MomentListContract {

  interface View extends BaseView {

    void displayMomentList(List<MomentModel> momentModels);

    void dismissRefreshingView();
  }

  interface Presenter extends BasePresenter<View> {

    void loadMoments();

    void refreshMoments();

    void saveInstanceState(Bundle outState);

    void loadSavedInstanceState(Bundle savedInstanceState);
  }
}
