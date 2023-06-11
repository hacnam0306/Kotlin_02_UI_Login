package com.example.fragmentloginui.authentication.model

import com.google.gson.annotations.SerializedName

data class LoginResponse (
    @SerializedName("_id")
    val id: String,
    val fullName: String,
    val email: String,
    val password: String,
    val createdAt: String,
    val updatedAt: String,
    @SerializedName("__v")
    val v: Long,
    val refreshToken: String,
    val bio: String,
    @SerializedName("facebookId")
    val facebookID: String,
    @SerializedName("instagramId")
    val instagramID: String,
    val location: String,
    val portfolio: String,
    val userName: String,
    val avatar: String
)
