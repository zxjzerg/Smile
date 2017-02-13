package com.zxjdev.smile.presentation.moment.list.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zxjdev.smile.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MomentViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_content) TextView tvContent;
    @BindView(R.id.tv_name) TextView tvName;
    @BindView(R.id.iv_avatar) ImageView ivAvatar;

    public MomentViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
