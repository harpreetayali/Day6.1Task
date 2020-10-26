package com.harpreetayali.day61task.ViewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.harpreetayali.day61task.Models.LoginModel
import com.harpreetayali.day61task.Retrofit.JSONClient
import com.harpreetayali.day61task.Retrofit.JsonAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel:ViewModel()
{
    var jsonApi = JSONClient.client?.create(JsonAPI::class.java)
    var loginResult = MutableLiveData<LoginModel>()

    fun getLoginResult(email:String,password:String):LiveData<LoginModel>
    {
        val call = jsonApi?.loginUser(email,password)
        Log.i("Credent","$email : $password")
        call!!.enqueue(object : Callback<LoginModel> {
            override fun onResponse(call: Call<LoginModel>, response: Response<LoginModel>) {
                loginResult.value = response.body()
                Log.i("login", "Result : ${response.body()?.error}")
            }

            override fun onFailure(call: Call<LoginModel>, t: Throwable) {
                Log.i("LoginError", t.message)
            }
        })

        return loginResult
    }

}