package com.example.fragmentloginui.authentication.services

import com.example.fragmentloginui.authentication.model.LoginRequest
import com.example.fragmentloginui.authentication.model.LoginResponse
import com.example.fragmentloginui.home.noteList.model.Post
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

fun apiServiceCreate() : APIServices = getService()
interface APIServices {
    @POST("auth/login")
    suspend fun login(@Body request :LoginRequest) : LoginResponse
    @GET("post")
    suspend fun getPost() : ArrayList<Post>
}
fun getService():APIServices{
    val retrofit  = Retrofit.Builder().baseUrl("http://13.211.252.44:3060/").addConverterFactory(GsonConverterFactory.create()).build()
    return  retrofit.create(APIServices::class.java)
}
