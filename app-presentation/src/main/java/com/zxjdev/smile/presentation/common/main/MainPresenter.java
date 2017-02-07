package com.zxjdev.smile.presentation.common.main;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;

    public MainPresenter(MainContract.View view) {
        this.view = view;
    }

    public void setView(MainContract.View view) {
        this.view = view;
    }
}
