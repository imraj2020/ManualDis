package com.mehedi.manualdiu.data.models.profile


import com.google.gson.annotations.SerializedName

data class Response_Profile(
    @SerializedName("avatar")
    val avatar: String? = null,
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("password")
    val password: String? = null,
    @SerializedName("role")
    val role: String? = null
)