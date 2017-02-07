package com.zxjdev.smile.presentation.moment.create;

import android.content.Context;

public interface NewMomentContract {

    interface View {

        Context context();

        void close();
    }

    interface Presenter {

        void destroy();

        void handleAddMoment(String context);
    }
}
