package com.mehedi.manualdiu.data.models.token


import com.google.gson.annotations.SerializedName

data class ResponseToken(
    @SerializedName("access_token")
    val accessToken: String? = null,
    @SerializedName("refresh_token")
    val refreshToken: String? = null
)