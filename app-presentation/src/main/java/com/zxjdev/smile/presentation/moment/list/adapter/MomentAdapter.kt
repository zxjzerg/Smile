package com.zxjdev.smile.presentation.moment.list.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.zxjdev.smile.R
import com.zxjdev.smile.presentation.common.util.image.ImageLoader
import com.zxjdev.smile.presentation.moment.MomentModel
import kotlinx.android.synthetic.main.item_moment.view.*
import java.text.SimpleDateFormat
import java.util.*

class MomentAdapter(private val imageLoader: ImageLoader) : RecyclerView.Adapter<MomentViewHolder>() {

    private var moments: List<MomentModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MomentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.item_moment, parent, false)
        return MomentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MomentViewHolder, position: Int) {
        val moment = moments[position]
        holder.itemView.tv_content.text = moment.content
        holder.itemView.tv_name.text = moment.owner!!.username
        holder.itemView.tv_time.text = parseCreateDate(moment.createAt)

        imageLoader.loadCircleImage(moment.owner!!.avatar, holder.itemView.iv_avatar)
    }

    override fun getItemCount(): Int {
        return moments.size
    }

    fun setMoments(moments: List<MomentModel>) {
        this.moments = moments

        notifyDataSetChanged()
    }

    private fun parseCreateDate(date: Date?): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.CHINA)
        return dateFormat.format(date)
    }
}

