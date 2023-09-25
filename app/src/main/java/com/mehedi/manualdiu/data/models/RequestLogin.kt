package com.mehedi.manualdiu.data.models


import com.google.gson.annotations.SerializedName

data class RequestLogin(
    @SerializedName("email")
    var email: String?,
    @SerializedName("password")
    var password: String?
)