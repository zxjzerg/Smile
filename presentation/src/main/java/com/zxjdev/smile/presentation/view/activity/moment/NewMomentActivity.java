package com.zxjdev.smile.presentation.view.activity.moment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;

import com.zxjdev.smile.R;
import com.zxjdev.smile.presentation.presenter.moment.NewMomentPresenter;
import com.zxjdev.smile.presentation.view.activity.base.BaseActivity;
import com.zxjdev.smile.presentation.view.i.moment.INewMomentView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewMomentActivity extends BaseActivity implements INewMomentView {

    @BindView(R.id.view_toolbar) Toolbar mViewToolbar;
    @BindView(R.id.et_content) EditText mEtContent;

    @Inject NewMomentPresenter mNewMomentPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        super.buildCommonInjector().inject(this);
        mNewMomentPresenter.setView(this);

        setContentView(R.layout.activity_new_moment);
        ButterKnife.bind(this);
        initUi();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mNewMomentPresenter.destroy();
    }

    @OnClick(R.id.btn_send)
    public void sendClick() {
        mNewMomentPresenter.handleAddMoment(mEtContent.getText().toString());
    }

    @Override
    public Context context() {
        return mContext;
    }

    @Override
    public void close() {
        onBackPressed();
    }

    private void initUi() {
        setSupportActionBar(mViewToolbar);
        if (getSupportActionBar() != null) getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
