package com.mehedi.manualdiu.ui.product.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import coil.load

import com.mehedi.manualdiu.databinding.RowCategoryBinding
import com.mehedi.manualdiu.ui.home.model.ResponseCategoryItem

class ProductAdapter(val categoryList: List<ResponseCategoryItem>, val listener: Listener) :
    RecyclerView.Adapter<ProductAdapter.VH>() {

    fun interface Listener {

        fun onCtgClick(ctg: ResponseCategoryItem)
    }

    class VH(val binding: RowCategoryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {

        return VH(RowCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {

        val ctg = categoryList[position]

        holder.binding.apply {

            categoryTitle.text = ctg.name
            categoryImg.load(ctg.image)

            root.setOnClickListener {
                listener.onCtgClick(ctg)
            }
        }

    }


}