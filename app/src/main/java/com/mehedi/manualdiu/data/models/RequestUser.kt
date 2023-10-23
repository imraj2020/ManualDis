package com.mehedi.manualdiu.data.models


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class RequestUser(
    @SerializedName("avatar")
    var avatar: String? = null,
    @SerializedName("email")
    var email: String? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("password")
    var password: String? = null
)