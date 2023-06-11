package com.example.fragmentloginui.home.noteList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fragmentloginui.authentication.services.APIServices
import com.example.fragmentloginui.authentication.services.apiServiceCreate
import com.example.fragmentloginui.home.noteList.model.Post
import com.example.fragmentloginui.home.noteList.utils.PostApiState
import kotlinx.coroutines.launch
import java.lang.Exception

class PostViewModel (private  val apiServices: APIServices = apiServiceCreate()) :ViewModel() {
    private  val _postLiveData: MutableLiveData<PostApiState> = MutableLiveData()
    val postLiveData get() =  _postLiveData

    fun getPost(){
        viewModelScope.launch {
            try {
                _postLiveData.value = PostApiState.loading
                val response: ArrayList<Post> = apiServices.getPost()
                _postLiveData.value = PostApiState.Success(response)
            }catch (e: Exception){
                _postLiveData.value = PostApiState.Error(e.message ?: "Login Error")
            }
        }
    }

}
