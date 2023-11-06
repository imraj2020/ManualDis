package com.mehedi.manualdiu.ui.product.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mehedi.manualdiu.databinding.ProductListBinding
import com.mehedi.manualdiu.ui.product.models.ResponseProductItem


class ProductListAdapter(val productList: List<ResponseProductItem>) :
    RecyclerView.Adapter<ProductListAdapter.VHF>() {


    class VHF(val binding: ProductListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHF {

        return VHF(ProductListBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    }

    override fun onBindViewHolder(holder: ProductListAdapter.VHF, position: Int) {

        val product = productList[position]
        holder.binding.apply {
            productTitle.text = product.title
//          productImg.load(product.images)
//          val imageUrl = productList[position].category?.image
//          productImg.load(imageUrl)

            val adapter = ProductImageAdapter(productList[position].images as List<String>)

            holder.binding.imageSlider.adapter = adapter


//            val imageUrls = productList[position].images?.get(0) // Get the first image URL

//            Glide.with(holder.itemView)
//                .load(imageUrls)
//                .into(holder.binding.productImg)
//
//        }

    }}

    override fun getItemCount(): Int {
        return productList.size
    }

//    override fun onBindViewHolder(holder: VH, position: Int) {
//
//        val ctg = categoryList[position]
//
//        holder.binding.apply {
//
//            categoryTitle.text = ctg.name
//            categoryImg.load(ctg.image)
//
//            root.setOnClickListener {
//                listener.onCtgClick(ctg)
//            }
//        }
//
//    }


}