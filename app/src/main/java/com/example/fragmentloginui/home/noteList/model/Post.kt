package com.example.fragmentloginui.home.noteList.model

import com.google.gson.JsonArray
import com.google.gson.annotations.SerializedName

data class Post (
    @SerializedName("_id")
    val id: String,

    val description: String,
    val title: String,

    @SerializedName("URL")
    val url: String,

    val user: String,
    val likes: JsonArray,
    val categories: List<String>,
    val comments: JsonArray,
    val createdAt: String,
    val updatedAt: String,

    @SerializedName("__v")
    val v: Long,

    @SerializedName("id")
    val welcomeID: String
)

