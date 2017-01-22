package com.zxjdev.smile.presentation.moment.list;

import android.content.Context;

public interface MomentsContract {

    interface View {

        Context context();
    }

    interface Presenter {

        void setView(View view);

        void create();

        void loadMoments();
    }
}
