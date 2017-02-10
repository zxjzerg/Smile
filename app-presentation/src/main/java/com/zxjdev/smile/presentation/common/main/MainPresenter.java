package com.zxjdev.smile.presentation.common.main;

import javax.inject.Inject;

public class MainPresenter implements MainContract.Presenter {

    @Inject MainContract.View view;

    @Inject
    public MainPresenter() {

    }

    public void setView(MainContract.View view) {
        this.view = view;
    }
}
