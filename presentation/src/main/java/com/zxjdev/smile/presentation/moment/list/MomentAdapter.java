package com.zxjdev.smile.presentation.moment.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zxjdev.smile.R;
import com.zxjdev.smile.presentation.moment.MomentModel;

import java.util.ArrayList;
import java.util.List;

public class MomentAdapter extends RecyclerView.Adapter<MomentViewHolder> {

    private List<MomentModel> moments = new ArrayList<>();

    public MomentAdapter() {

    }

    @Override
    public MomentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_moment, parent, false);
        return new MomentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MomentViewHolder holder, int position) {
        MomentModel moment = moments.get(position);
        holder.tvContet.setText(moment.getContent());
    }

    @Override
    public int getItemCount() {
        return moments.size();
    }

    public void setMoments(List<MomentModel> moments) {
        this.moments = moments;

        notifyDataSetChanged();
    }
}
