package com.zxjdev.smile.presentation.moment.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zxjdev.smile.R;
import com.zxjdev.smile.presentation.application.base.BaseFragment;
import com.zxjdev.smile.presentation.application.di.component.MomentsFragmentComponent;
import com.zxjdev.smile.presentation.application.di.module.MomentsFragmentModule;
import com.zxjdev.smile.presentation.common.main.MainActivity;
import com.zxjdev.smile.presentation.moment.create.NewMomentActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MomentsFragment extends BaseFragment {

    public static final String TAG = MomentsFragment.class.getSimpleName();

    @BindView(R.id.fbtn_add_new_moment) FloatingActionButton mBtnNewMoment;
    @Inject MomentAdapter mAdapter;

    private MomentsFragmentComponent mMomentsFragmentComponent;

    public MomentsFragment() {
        setRetainInstance(true);
    }

    @Override
    protected void initializeInjector() {
        if (getActivity() instanceof MainActivity) {
            mMomentsFragmentComponent = ((MainActivity) getActivity()).getComponent()
                .plus(new MomentsFragmentModule());
            mMomentsFragmentComponent.inject(this);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
        ViewGroup container,
        Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_moments, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMomentsFragmentComponent = null;
    }

    @OnClick(R.id.fbtn_add_new_moment)
    public void addNewMomentClick() {
        Intent addMoment = new Intent(getActivity(), NewMomentActivity.class);
        startActivity(addMoment);
    }
}
