package com.mehedi.manualdiu.data.models.token


import com.google.gson.annotations.SerializedName

data class RequestToken(
    @SerializedName("refreshToken")
    val refreshToken: String? = null
)