package com.example.cat1work

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VegetablesAdapter(
    private val items: List<Vegetable>,
    private val onItemClick: (Vegetable) -> Unit
) : RecyclerView.Adapter<VegetablesAdapter.VegetableViewHolder>() {

    class VegetableViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivVegetable: ImageView = itemView.findViewById(R.id.ivVegetable)
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvPrice: TextView = itemView.findViewById(R.id.tvPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VegetableViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_vegetable, parent, false)
        return VegetableViewHolder(view)
    }

    override fun onBindViewHolder(holder: VegetableViewHolder, position: Int) {
        val item = items[position]
        holder.tvName.text = item.name
        holder.tvPrice.text = item.price
        holder.ivVegetable.setImageResource(item.imageResId)

        holder.itemView.setOnClickListener {
            onItemClick(item)
        }
    }

    override fun getItemCount(): Int = items.size
}