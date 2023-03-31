package com.midhun.bapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.midhun.bapp.Model.Place
import com.midhun.bapp.R

class PlaceAdapter(var context: Context, var pageDataList: List<Place>) :
    RecyclerView.Adapter<PlaceAdapter.ProductsAdapterViewHolder>() {
    class ProductsAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView? = null;

        init {
            name = itemView.findViewById(R.id.name)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsAdapterViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.brand_custom, parent, false)
        return ProductsAdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductsAdapterViewHolder, position: Int) {
        var data = pageDataList.get(position)
        holder.name?.setText(data.place)
    }

    override fun getItemCount(): Int {
        return pageDataList.size
    }
}