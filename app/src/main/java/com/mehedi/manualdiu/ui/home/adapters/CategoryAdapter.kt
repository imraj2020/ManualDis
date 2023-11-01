package com.mehedi.manualdiu.ui.home.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.mehedi.manualdiu.databinding.RowCategoryBinding
import com.mehedi.manualdiu.ui.home.model.ResponseCategoryItem

class CategoryAdapter(val categoryList: List<ResponseCategoryItem>, val listener: Listener) :
    RecyclerView.Adapter<CategoryAdapter.VH>() {


    fun interface Listener {
        fun onCtgClicked(ctg: ResponseCategoryItem)
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

        Log.d("TAG", "onBindViewHolder: ${ctg.name}")

        holder.binding.apply {
            categoryTitle.text = ctg.name
            categoryImg.load(ctg.image)

            root.setOnClickListener {

                listener.onCtgClicked(ctg)
            }

        }


    }

}