package com.mehedi.manualdiu.ui.product.models


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class ResponseProductItem(
    @SerializedName("category")
    var category: Category? = null,
    @SerializedName("creationAt")
    var creationAt: String? = null,
    @SerializedName("description")
    var description: String? = null,
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("images")
    var images: List<String?>? = null,
    @SerializedName("price")
    var price: Int? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("updatedAt")
    var updatedAt: String? = null
)