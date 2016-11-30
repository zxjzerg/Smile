package com.zxjdev.smile.presentation.view.activity.moment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zxjdev.smile.R;
import com.zxjdev.smile.presentation.view.activity.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MomentsFragment extends BaseFragment {

    public static final String TAG = MomentsFragment.class.getSimpleName();

    @BindView(R.id.fbtn_add_new_moment) FloatingActionButton mBtnNewMoment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

    @OnClick(R.id.fbtn_add_new_moment)
    public void addNewMomentClick() {
        Intent addMoment = new Intent(getActivity(), NewMomentActivity.class);
        startActivity(addMoment);
    }
}
