package com.midhun.bapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.midhun.bapp.Model.Category
import com.midhun.bapp.Model.Place
import com.midhun.bapp.R

class CategoryAdapter(var context: Context, var categoryList: List<Category>) :
    RecyclerView.Adapter<CategoryAdapter.ProductsAdapterViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsAdapterViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.brand_custom, parent, false)
        return ProductsAdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductsAdapterViewHolder, position: Int) {
        var data = categoryList.get(position)
        holder.name?.setText(data.key)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    class ProductsAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView? = null;

        init {
            name = itemView.findViewById(R.id.name)
        }

    }
}