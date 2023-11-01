package com.mehedi.manualdiu.ui.product.models


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Category(
    @SerializedName("creationAt")
    var creationAt: String? = null,
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("image")
    var image: String? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("updatedAt")
    var updatedAt: String? = null
)