package com.example.fragmentloginui.authentication.services

import com.example.fragmentloginui.authentication.model.LoginResponse

sealed class AuthApiState{
    object loading : AuthApiState()

    data class Success(val response : LoginResponse) : AuthApiState()
    data class Error (val message : String) : AuthApiState()
}
