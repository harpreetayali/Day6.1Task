package com.harpreetayali.day61task.Retrofit

import com.harpreetayali.day61task.Models.LoginModel
import com.harpreetayali.day61task.Models.UsersListModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface JsonAPI
{

    @GET("users?page=2")
    fun getUsers():Call<UsersListModel>

    @FormUrlEncoded
    @POST("login")
    fun loginUser(@Field("email") email:String,
                  @Field("password") password:String):Call<LoginModel>
}