package com.zxjdev.smile.presentation.moment.create;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.zxjdev.smile.R;
import com.zxjdev.smile.presentation.application.base.activity.BaseActivity;
import com.zxjdev.smile.presentation.moment.create.di.NewMomentActivityComponent;
import com.zxjdev.smile.presentation.moment.create.di.NewMomentActivityModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewMomentActivity extends BaseActivity implements NewMomentContract.View {

    @BindView(R.id.view_toolbar) Toolbar toolbar;
    @BindView(R.id.et_content) EditText etContent;

    @Inject NewMomentContract.Presenter presenter;

    private NewMomentActivityComponent newMomentActivityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_moment);
        ButterKnife.bind(this);
        initUi();

        presenter.setView(this);
    }

    @Override
    protected void initializeInjector() {
        newMomentActivityComponent = getActivityComponent().getNewMomentActivityComponent(
            new NewMomentActivityModule());
        newMomentActivityComponent.inject(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destroy();
        newMomentActivityComponent = null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_new_moment, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_send:
                presenter.handleAddMoment(etContent.getText().toString());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public Context context() {
        return context;
    }

    @Override
    public void close() {
        onBackPressed();
    }

    private void initUi() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
