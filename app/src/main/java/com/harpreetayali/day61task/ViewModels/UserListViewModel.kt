package com.harpreetayali.day61task.ViewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.harpreetayali.day61task.Retrofit.JSONClient
import com.harpreetayali.day61task.Retrofit.JsonAPI
import com.harpreetayali.day61task.Models.UsersListModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserListViewModel : ViewModel() {

    var jsonApi = JSONClient.client?.create(JsonAPI::class.java)
    var users_list = MutableLiveData<UsersListModel>()

    fun getResult(): LiveData<UsersListModel>
    {
        val call = jsonApi?.getUsers()

        call!!.enqueue(object : Callback<UsersListModel?> {
            override fun onResponse(call: Call<UsersListModel?>, response: Response<UsersListModel?>) {
                users_list.value = response.body()
                Log.i("login", response.body()?.data?.get(0)?.first_name)
            }

            override fun onFailure(call: Call<UsersListModel?>, t: Throwable) {
                Log.i("LoginError", t.message)
            }
        })

        return users_list

    }
}