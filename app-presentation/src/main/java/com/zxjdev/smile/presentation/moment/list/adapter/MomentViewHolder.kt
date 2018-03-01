package com.zxjdev.smile.presentation.moment.list.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.zxjdev.smile.R

class MomentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    @BindView(R.id.tv_content) lateinit var tvContent: TextView
    @BindView(R.id.tv_name) lateinit var tvName: TextView
    @BindView(R.id.iv_avatar) lateinit var ivAvatar: ImageView
    @BindView(R.id.tv_time) lateinit var tvTime: TextView

    init {
        ButterKnife.bind(this, itemView)
    }
}
