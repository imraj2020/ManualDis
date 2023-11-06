package com.mehedi.manualdiu.ui.product.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.mehedi.manualdiu.databinding.RowCategoryImageSliderBinding

class ProductImageAdapter(val imageList: List<String>) :
    RecyclerView.Adapter<ProductImageAdapter.VH>() {


    class VH(val binding: RowCategoryImageSliderBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {

        return VH(
            RowCategoryImageSliderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {

        val image = imageList[position]

        holder.binding.apply {

            sliderImageView.load(image)


        }

    }


}