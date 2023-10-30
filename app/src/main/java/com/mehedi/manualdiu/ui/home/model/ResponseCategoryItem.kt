package com.mehedi.manualdiu.ui.home.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class ResponseCategoryItem(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("image")
    var image: String? = null,
    @SerializedName("name")
    var name: String? = null
)