package com.harpreetayali.day61task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.harpreetayali.day61task.Adapters.UserListAdapter
import com.harpreetayali.day61task.Models.Data
import com.harpreetayali.day61task.ViewModels.UserListViewModel

class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var recyclerView:RecyclerView = findViewById(R.id.user_recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val model = ViewModelProvider(this).get(UserListViewModel::class.java)

        model.getResult().observe(this, Observer {
            var list:ArrayList<Data> = it.data as ArrayList<Data>
            recyclerView.adapter = UserListAdapter(list,this)
        })



    }
}