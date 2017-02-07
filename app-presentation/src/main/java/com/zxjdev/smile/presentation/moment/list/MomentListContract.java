package com.zxjdev.smile.presentation.moment.list;

import android.content.Context;

public interface MomentListContract {

    interface View {

        Context context();
    }

    interface Presenter {

        void create();

        void loadMoments();
    }
}
