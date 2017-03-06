package com.zxjdev.smile.presentation.moment.create;

public interface NewMomentContract {

    interface View {

        void close();
    }

    interface Presenter {

        void destroy();

        void handleAddMoment(String context);
    }
}
