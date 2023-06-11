package com.example.fragmentloginui.home.noteList.utils

import com.example.fragmentloginui.home.noteList.model.Post


sealed class PostApiState{
    object loading : PostApiState()
    data class Success(val response : ArrayList<Post>) : PostApiState()
    data class Error (val message : String) : PostApiState()
}
