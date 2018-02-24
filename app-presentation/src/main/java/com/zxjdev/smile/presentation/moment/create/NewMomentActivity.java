package com.zxjdev.smile.presentation.moment.create;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.zxjdev.smile.R;
import com.zxjdev.smile.presentation.common.base.activity.ActivityModule;
import com.zxjdev.smile.presentation.common.base.activity.DaggerActivity;
import com.zxjdev.smile.presentation.moment.create.di.NewMomentActivityComponent;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewMomentActivity extends DaggerActivity implements NewMomentContract.View {

  @BindView(R.id.view_toolbar) Toolbar toolbar;
  @BindView(R.id.et_content) EditText etContent;

  @Inject NewMomentPresenter presenter;

  private NewMomentActivityComponent newMomentActivityComponent;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_new_moment);
    ButterKnife.bind(this);
    initUi();

    presenter.takeView(this);
  }

  @Override
  protected void initDaggerComponent() {
    newMomentActivityComponent = getApplicationComponent().getNewMomentActivityComponent(new ActivityModule(this));
    newMomentActivityComponent.inject(this);
  }

  @Override
  protected void releaseDaggerComponent() {

  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    presenter.dropView();
    newMomentActivityComponent = null;
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_new_moment, menu);
    // Tint the icon in menu to white
    menu.findItem(R.id.action_send).getIcon().setTint(getResources().getColor(android.R.color.white));
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
  public void close() {
    onBackPressed();
  }

  private void initUi() {
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setTitle(null);
  }
}
