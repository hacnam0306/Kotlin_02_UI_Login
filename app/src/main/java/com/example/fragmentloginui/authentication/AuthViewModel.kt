package com.example.fragmentloginui.authentication

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fragmentloginui.authentication.model.LoginRequest
import com.example.fragmentloginui.authentication.model.LoginResponse
import com.example.fragmentloginui.authentication.services.APIServices
import com.example.fragmentloginui.authentication.services.AuthApiState
import com.example.fragmentloginui.authentication.services.apiServiceCreate
import kotlinx.coroutines.launch
import java.lang.Exception

class AuthViewModel(private val apiServices: APIServices = apiServiceCreate()) :ViewModel() {
private  val _authLiveData: MutableLiveData<AuthApiState> = MutableLiveData()

    val authLiveData get() =  _authLiveData

    fun login(loginFormData: LoginRequest){
        viewModelScope.launch {
           try {
               _authLiveData.value = AuthApiState.loading
               val response:LoginResponse = apiServices.login(loginFormData)
               _authLiveData.value = AuthApiState.Success(response)

           }catch (e:Exception){
               _authLiveData.value = AuthApiState.Error(e.message ?: "Login Error")
           }
        }
    }
}

