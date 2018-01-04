package com.zxjdev.smile.presentation.moment.list;

import android.os.Bundle;

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

    void saveInstanceState(Bundle outState);

    void loadSavedInstanceState(Bundle savedInstanceState);
  }
}
