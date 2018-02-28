package com.zxjdev.smile.presentation.moment.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zxjdev.smile.R;
import com.zxjdev.smile.presentation.common.base.fragment.BaseFragment;
import com.zxjdev.smile.presentation.moment.MomentModel;
import com.zxjdev.smile.presentation.moment.create.NewMomentActivity;
import com.zxjdev.smile.presentation.moment.list.adapter.MomentAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MomentListFragment extends BaseFragment implements MomentListContract.View {

  public static final String TAG = MomentListFragment.class.getSimpleName();

  @BindView(R.id.rv_moments) RecyclerView rvMoments;
  @BindView(R.id.fbtn_add_new_moment) FloatingActionButton btnNewMoment;
  @BindView(R.id.layout_swipe) SwipeRefreshLayout layoutSwipe;

  private MomentAdapter momentAdapter;
  @Inject MomentListPresenter presenter;

  public MomentListFragment() {

  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);
    View view = inflater.inflate(R.layout.fragment_moments, container, false);
    ButterKnife.bind(this, view);
    initUi();
    return view;
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    presenter.takeView(this);
    if (savedInstanceState == null) {
      presenter.loadMoments();
    } else {
      presenter.loadSavedInstanceState(savedInstanceState);
    }
  }

  private void initUi() {
    rvMoments.setLayoutManager(new LinearLayoutManager(getActivity()));
    momentAdapter = new MomentAdapter(super.getImageLoader());
    rvMoments.setAdapter(momentAdapter);

    layoutSwipe.setColorSchemeResources(R.color.colorAccent);
    layoutSwipe.setOnRefreshListener(() -> presenter.refreshMoments());
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    presenter.dropView();
  }

  @Override
  public void onSaveInstanceState(Bundle outState) {
    presenter.saveInstanceState(outState);
    super.onSaveInstanceState(outState);
  }

  @OnClick(R.id.fbtn_add_new_moment)
  public void addNewMomentClick() {
    Intent addMoment = new Intent(getActivity(), NewMomentActivity.class);
    startActivity(addMoment);
  }

  @Override
  public void displayMomentList(List<MomentModel> momentModels) {
    momentAdapter.setMoments(momentModels);
  }

  @Override
  public void dismissRefreshingView() {
    layoutSwipe.setRefreshing(false);
  }
}
