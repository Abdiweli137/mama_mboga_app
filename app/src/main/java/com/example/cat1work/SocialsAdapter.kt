package com.example.cat1work

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SocialsAdapter(
    private val items: List<SocialItem>
) : RecyclerView.Adapter<SocialsAdapter.SocialViewHolder>() {

    class SocialViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivSocialIcon: ImageView = itemView.findViewById(R.id.ivSocialIcon)
        val tvSocialName: TextView = itemView.findViewById(R.id.tvSocialName)
        val tvSocialDetail: TextView = itemView.findViewById(R.id.tvSocialDetail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SocialViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_social, parent, false)
        return SocialViewHolder(view)
    }

    override fun onBindViewHolder(holder: SocialViewHolder, position: Int) {
        val item = items[position]
        holder.tvSocialName.text = item.name
        holder.tvSocialDetail.text = item.detail
        holder.ivSocialIcon.setImageResource(item.iconResId)
    }

    override fun getItemCount(): Int = items.size
}