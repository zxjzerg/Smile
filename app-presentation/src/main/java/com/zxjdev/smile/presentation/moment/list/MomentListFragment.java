package com.zxjdev.smile.presentation.moment.list;

import android.content.Context;
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
import com.zxjdev.smile.presentation.application.base.fragment.BaseFragment;
import com.zxjdev.smile.presentation.application.base.fragment.FragmentModule;
import com.zxjdev.smile.presentation.common.main.MainActivity;
import com.zxjdev.smile.presentation.moment.MomentModel;
import com.zxjdev.smile.presentation.moment.create.NewMomentActivity;
import com.zxjdev.smile.presentation.moment.list.adapter.MomentAdapter;
import com.zxjdev.smile.presentation.moment.list.di.MomentListFragmentComponent;
import com.zxjdev.smile.presentation.moment.list.di.MomentListFragmentModule;

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

    @Inject MomentAdapter momentAdapter;
    @Inject MomentListContract.Presenter presenter;

    private MomentListFragmentComponent momentListFragmentComponent;

    public MomentListFragment() {

    }

    @Override
    protected void initDaggerComponent() {
        if (getActivity() instanceof MainActivity) {
            momentListFragmentComponent = ((MainActivity) getActivity()).getComponent()
                .getMomentsFragmentComponent(new FragmentModule(this),
                    new MomentListFragmentModule(this));
            momentListFragmentComponent.inject(this);
        }
    }

    @Override
    protected void releaseDaggerComponent() {
        momentListFragmentComponent = null;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
        ViewGroup container,
        Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_moments, container, false);
        ButterKnife.bind(this, view);
        initUi();
        return view;
    }

    @Override
    protected void onDependencyReady() {
        rvMoments.setAdapter(momentAdapter);
    }

    @Override
    protected void onInitialized() {
        presenter.create();
    }

    private void initUi() {
        rvMoments.setLayoutManager(new LinearLayoutManager(getActivity()));

        layoutSwipe.setColorSchemeResources(R.color.colorAccent);
        layoutSwipe.setOnRefreshListener(() -> presenter.refreshMoments());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        momentListFragmentComponent = null;
    }

    @OnClick(R.id.fbtn_add_new_moment)
    public void addNewMomentClick() {
        Intent addMoment = new Intent(getActivity(), NewMomentActivity.class);
        startActivity(addMoment);
    }

    @Override
    public Context context() {
        return getActivity();
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
