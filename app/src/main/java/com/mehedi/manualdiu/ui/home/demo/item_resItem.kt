package com.mehedi.manualdiu.ui.home.demo


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class item_resItem(
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