package com.zxjdev.smile.presentation.moment.create;

import com.zxjdev.smile.presentation.common.base.BasePresenter;
import com.zxjdev.smile.presentation.common.base.BaseView;

public interface NewMomentContract {

  interface View extends BaseView {

    void close();
  }

  interface Presenter extends BasePresenter<View> {

    void handleAddMoment(String context);
  }
}
