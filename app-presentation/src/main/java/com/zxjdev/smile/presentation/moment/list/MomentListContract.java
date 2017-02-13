package com.zxjdev.smile.presentation.moment.list;

import android.content.Context;

import com.zxjdev.smile.presentation.moment.MomentModel;

import java.util.List;

public interface MomentListContract {

    interface View {

        Context context();

        void displayMomentList(List<MomentModel> momentModels);

        void dismissRefreshingView();
    }

    interface Presenter {

        void create();

        void loadMoments();

        void refreshMoments();
    }
}
