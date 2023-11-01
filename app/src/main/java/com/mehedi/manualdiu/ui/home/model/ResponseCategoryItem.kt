package com.mehedi.manualdiu.ui.home.model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class ResponseCategoryItem(
    @SerializedName("id")
    var id: Int,
    @SerializedName("image")
    var image: String? = null,
    @SerializedName("name")
    var name: String? = null
)