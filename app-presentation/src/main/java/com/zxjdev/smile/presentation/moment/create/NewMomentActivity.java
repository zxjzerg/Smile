package com.zxjdev.smile.presentation.moment.create;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;

import com.zxjdev.smile.R;
import com.zxjdev.smile.presentation.application.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewMomentActivity extends BaseActivity implements NewMomentContract.View {

    @BindView(R.id.view_toolbar) Toolbar mViewToolbar;
    @BindView(R.id.et_content) EditText mEtContent;

    @Inject NewMomentContract.Presenter mPresenter;

    private NewMomentComponent mNewMomentComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_moment);
        ButterKnife.bind(this);
        initUi();

        mPresenter.setView(this);
    }

    @Override
    protected void initializeInjector() {
        mNewMomentComponent = getActivityComponent().getNewMomentComponent();
        mNewMomentComponent.inject(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.destroy();
        mNewMomentComponent = null;
    }

    @OnClick(R.id.btn_send)
    public void sendClick() {
        mPresenter.handleAddMoment(mEtContent.getText().toString());
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
