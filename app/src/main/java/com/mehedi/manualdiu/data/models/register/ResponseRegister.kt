package com.mehedi.manualdiu.data.models.register


import com.google.gson.annotations.SerializedName

data class ResponseRegister(
    @SerializedName("avatar")
    var avatar: String?,
    @SerializedName("email")
    var email: String?,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("password")
    var password: String?,
    @SerializedName("role")
    var role: String?
)